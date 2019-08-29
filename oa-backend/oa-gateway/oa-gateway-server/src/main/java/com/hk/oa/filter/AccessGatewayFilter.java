package com.hk.oa.filter;

import com.alibaba.fastjson.JSONObject;
import com.hk.oa.auth.client.properties.AuthClientProperties;
import com.hk.oa.auth.client.utils.JwtTokenClientUtils;
import com.hk.oa.auth.utils.JwtUserInfo;
import com.hk.oa.common.constant.BaseContextConstants;
import com.hk.oa.common.msg.BaseResponse;
import com.hk.oa.common.msg.auth.TokenForbiddenResponse;
import com.hk.oa.config.IgnoreTokenConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @program: hk-oa-master
 * @description: 全剧过滤器
 * @author: 陈家乐
 * @create: 2019-08-24 16:26
 **/

@Slf4j
@Component
public class AccessGatewayFilter implements GlobalFilter {
    private static final String GATE_WAY_PREFIX = "/api";
    @Autowired
    private IgnoreTokenConfig ignoreTokenConfig;

    @Autowired
    private AuthClientProperties authClientProperties;

    @Autowired
    private JwtTokenClientUtils jwtTokenClientUtils;


    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain) {
        log.info("Gateway接收请求路径: {}",serverWebExchange.getRequest().getPath().pathWithinApplication().value());
        LinkedHashSet requiredAttribute = serverWebExchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
        ServerHttpRequest request = serverWebExchange.getRequest();
        String requestUri = request.getPath().pathWithinApplication().value();

        if (requiredAttribute != null) {
            Iterator<URI> iterator = requiredAttribute.iterator();
            while (iterator.hasNext()) {
                URI next = iterator.next();
                if (next.getPath().startsWith(GATE_WAY_PREFIX)) {
                   requestUri = next.getPath().substring(GATE_WAY_PREFIX.length());
                }
            }
        }
        ServerHttpRequest.Builder mutate = request.mutate();

        // 不进行拦截的地址
        if (isIgnoreToken(requestUri)) {
            ServerHttpRequest build = mutate.build();
            return gatewayFilterChain.filter(serverWebExchange.mutate().request(build).build());
        }

        JwtUserInfo userInfo = null;
        try {
            userInfo = getJWTUser(authClientProperties.getUser().getHeaderName(), request);
        } catch (Exception e) {
            log.error("用户Token过期异常：{}", e);
            return getVoidMono(serverWebExchange, new TokenForbiddenResponse("登录过期，请重新登录!"));
        }
        log.info("userInfo={}", userInfo);




        // redis key
       // String redisKey = String.format(CommonConstants.REDIS_JWT_EXPIRE_KEY, user.getId());
        // 获取当前token超时时间
       // String expireDate = redisTemplate.opsForValue().get(redisKey);
        try {
           /* if (ValidateUtil.isNotNull(expireDate) && ((DateUtil.parseTime(expireDate).getTime() - System.currentTimeMillis()) / 1000) < allowRefresh) {
                // 获取当前请求token
                String token = this.getToken(request);
                String newToken = authService.refreshToken(token);
                log.info("当前用户：{}-{} 请求token：{}, 刷新后token：{}", user.getId(), user.getName(), token, newToken);
                serverWebExchange.getResponse().getHeaders().set(refreshTokenHeader, newToken);
                // 刷新redis中当前用户token超时时间
                redisTemplate.opsForValue().set(redisKey, DateUtil.format(DateUtils.addSeconds(new Date(), expire), DateUtil.fm_yyyy_MM_dd_HHmmssSSS));
            }*/

            //将信息放入header,以便后台取数据
            mutate.header( BaseContextConstants.JWT_KEY_ACCOUNT, userInfo.getAccount());
            mutate.header(BaseContextConstants.JWT_KEY_USER_ID, userInfo.getUserId());
            mutate.header(BaseContextConstants.JWT_KEY_NAME, userInfo.getName());
            mutate.header( BaseContextConstants.JWT_KEY_DEP_ID, userInfo.getDepartmentId());
            mutate.header( BaseContextConstants.JWT_KEY_ROLE_ID, userInfo.getRoleId());

        } catch (Exception e) {
            log.error("当前用户：{},刷新Token异常：{} ", userInfo.getUserId(), e.getMessage());
            e.printStackTrace();
            return getVoidMono(serverWebExchange, new TokenForbiddenResponse("登录失效，请重新登录！"));
        }
        ServerHttpRequest build = mutate.build();
        return gatewayFilterChain.filter(serverWebExchange.mutate().request(build).build());
    }




    /**
     * 返回session中的用户信息
     *
     * @param request
     * @param
     * @return
     */
    private JwtUserInfo getJWTUser(String headerName,ServerHttpRequest request) throws Exception {
        String userToken = request.getHeaders().getFirst(headerName);
        return jwtTokenClientUtils.getUserInfo(userToken);
    }



    private boolean isIgnoreToken(String requestUri) {
       return ignoreTokenConfig.isIgnoreToken(requestUri);
    }

    /**
     * 网关抛异常
     *
     * @param body
     */
    @NotNull
    private Mono<Void> getVoidMono(ServerWebExchange serverWebExchange, BaseResponse body) {
        serverWebExchange.getResponse().setStatusCode(HttpStatus.OK);
        byte[] bytes = JSONObject.toJSONString(body).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = serverWebExchange.getResponse().bufferFactory().wrap(bytes);
        return serverWebExchange.getResponse().writeWith(Flux.just(buffer));
    }
}
