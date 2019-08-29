package com.hk.oa.user.interceptor;

import com.hk.oa.common.constant.BaseContextConstants;
import com.hk.oa.common.context.BaseContextHandler;
import com.hk.oa.common.utils.StrHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 网关：
 * 获取token，并解析，然后将所有的用户、应用信息封装到请求头
 * <p>
 * 拦截器：
 * 解析请求头数据， 将用户信息、应用信息封装到BaseContextHandler
 * 考虑请求来源是否网关（ip等）
 * <p>
 * Created by zuihou on 2017/9/10.
 *
 * @author zuihou
 * @date 2019-06-20 22:22
 */
@Slf4j
public class ContextHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            log.info("not exec!!! url={}", request.getRequestURL());
            return super.preHandle(request, response, handler);
        }

        String userId = getHeader(request, BaseContextConstants.JWT_KEY_USER_ID);
        String account = getHeader(request, BaseContextConstants.JWT_KEY_ACCOUNT);
        String name = getHeader(request, BaseContextConstants.JWT_KEY_NAME);
        String depId = getHeader(request, BaseContextConstants.JWT_KEY_DEP_ID);
        String roleId = getHeader(request, BaseContextConstants.JWT_KEY_ROLE_ID);
        BaseContextHandler.setUserId(userId);
        BaseContextHandler.setAccount(account);
        BaseContextHandler.setName(name);
        BaseContextHandler.setDepId(depId);
        BaseContextHandler.setRoleId(roleId);
        return super.preHandle(request, response, handler);
    }

    private String getHeader(HttpServletRequest request, String name) {
        String value = request.getHeader(name);
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return StrHelper.decode(value);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
