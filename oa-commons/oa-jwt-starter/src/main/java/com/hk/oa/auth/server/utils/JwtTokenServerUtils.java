package com.hk.oa.auth.server.utils;

import com.hk.oa.auth.server.properties.AuthServerProperties;
import com.hk.oa.auth.utils.JwtHelper;
import com.hk.oa.auth.utils.JwtUserInfo;
import com.hk.oa.auth.utils.Token;
import com.hk.oa.common.exception.BizException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * jwt token 工具
 *
 * @author zuihou
 * @date 2018/11/20
 */
@AllArgsConstructor
@Component
public class JwtTokenServerUtils {
    /**
     * 认证服务端使用，如 authority-server
     * 生成和 解析token
     */
    private AuthServerProperties authServerProperties;

    /**
     * 生成token
     *
     * @param jwtInfo
     * @param expire
     * @return
     * @throws BizException
     */
    public Token generateUserToken(JwtUserInfo jwtInfo, Integer expire) throws BizException {
        AuthServerProperties.TokenInfo userTokenInfo = authServerProperties.getUser();
        if (expire == null || expire <= 0) {
            expire = userTokenInfo.getExpire();
        }
        return JwtHelper.generateUserToken(jwtInfo, userTokenInfo.getPriKey(), expire);
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     * @throws BizException
     */
    public JwtUserInfo getUserInfo(String token) throws BizException {
        AuthServerProperties.TokenInfo userTokenInfo = authServerProperties.getUser();
        return JwtHelper.getJwtFromToken(token, userTokenInfo.getPubKey());
    }


}
