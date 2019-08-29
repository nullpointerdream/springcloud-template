package com.hk.oa.authority.config;

import com.alibaba.fastjson.JSONObject;


import com.hk.oa.log.event.SysLogListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 日志自动配置
 *
 * @author zuihou
 * @date 2019/07/02
 */
@EnableAsync
@Configuration
public class LogConfiguration {

    @Bean
    public SysLogListener sysLogListener() {
        return new SysLogListener((log) -> JSONObject.toJSONString(log));
    }
}
