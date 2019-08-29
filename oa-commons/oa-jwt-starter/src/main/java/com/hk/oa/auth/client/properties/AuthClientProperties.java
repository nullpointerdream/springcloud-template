package com.hk.oa.auth.client.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static com.hk.oa.auth.client.properties.AuthClientProperties.PREFIX;


/**
 * 客户端认证配置
 *
 * @author zuihou
 * @date 2018/11/20
 */
@ConfigurationProperties(prefix = PREFIX)//@ConfigurationProperties，它可以把同类的配置信息自动封装成实体类
@Data
@NoArgsConstructor
@Component
public class AuthClientProperties {
    public static final String PREFIX = "authentication";

    private TokenInfo user;

    @Data
    public static class TokenInfo {
        /**
         * 请求头名称
         */
        private String headerName;
        /**
         * 解密 网关使用
         */
        private String pubKey;
    }

}
