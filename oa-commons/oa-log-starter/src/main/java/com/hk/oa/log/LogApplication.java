package com.hk.oa.log;

import com.hk.oa.log.aspect.SysLogAspect;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 日志自动配置
 * <p>
 * 启动条件：
 * 1，存在web环境
 * 2，配置文件中zuihou.log.enabled=true
 * 3，配置文件中不存在：zuihou.log.enabled 值
 *
 * @author zuihou
 * @date 2019/2/1
 */
@EnableAsync
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
@ConditionalOnProperty(name = "oa.log.enabled", havingValue = "true", matchIfMissing = true)
public class LogApplication {

    @Bean
    public SysLogAspect sysLogAspect() {
        return new SysLogAspect();
    }

}
