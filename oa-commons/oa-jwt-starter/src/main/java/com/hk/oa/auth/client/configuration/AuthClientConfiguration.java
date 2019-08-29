package com.hk.oa.auth.client.configuration;


import com.hk.oa.auth.client.properties.AuthClientProperties;
import com.hk.oa.auth.client.utils.JwtTokenClientUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 客户端认证配置
 *
 * @author zuihou
 * @createTime 2017-12-13 15:27
 */
@EnableConfigurationProperties(value = {
        AuthClientProperties.class,
})//@ConfigurationProperties注解生效。如果只配置@ConfigurationProperties注解，在IOC容器中是获取不到properties配置文件转化的bean的
public class AuthClientConfiguration {
    @Bean
    public JwtTokenClientUtils getJwtTokenClientUtils(AuthClientProperties authClientProperties) {
        return new JwtTokenClientUtils(authClientProperties);
    }

}
