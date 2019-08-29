package com.hk.oa.redis.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.Map;

/**
 * 主要用来设置通过 @Cacheable 注解标注的方法的缓存策略
 *
 * @author zuihou
 * @date 2019/08/06
 */
@Data
@ConfigurationProperties(prefix = "zuihou.cache")
public class CustomCacheProperties {
    /**
     * 全局配置
     */
    private Redis redis = new Redis();

    /**
     * 针对某几个具体的key特殊配置
     * configs的key需要配置成@Cacheable注解的value
     */
    private Map<String, Redis> configs;

    @Data
    public static class Redis {

        /**
         * key 的过期时间
         * 默认1天过期
         * eg:
         * timeToLive: 1d
         */
        private Duration timeToLive = Duration.ofDays(1);

        /**
         * 是否允许缓存null值
         */
        private boolean cacheNullValues = true;

        /**
         * key 的前缀
         * 最后的key格式： keyPrefix + @Cacheable.value + @Cacheable.key
         */
        private String keyPrefix;

        /**
         * 写入redis时，是否使用key前缀
         */
        private boolean useKeyPrefix = true;
        /**
         * Caffeine 的最大缓存个数
         */
        private int maxSize = 1000;


    }

}
