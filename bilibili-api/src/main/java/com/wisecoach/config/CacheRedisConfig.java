package com.wisecoach.config;

import com.wisecoach.config.properties.CacheRedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 * @author wisecoach
 */
@Configuration
@EnableConfigurationProperties(CacheRedisProperties.class)
@EnableCaching
public class CacheRedisConfig{

    private final CacheRedisProperties properties;

    public CacheRedisConfig(CacheRedisProperties properties) {
        this.properties = properties;
    }

    @Bean
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(target.getClass().getName())
                    .append(method.getName());
                for (Object object : params) {
                    stringBuilder.append(object.toString());
                }
                return stringBuilder.toString();
            }
        };
    }

    @Bean
    public CacheManager cacheManager(@Autowired RedisTemplate redisTemplate){
        RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
        return new RedisCacheManager(
            RedisCacheWriter.lockingRedisCacheWriter(factory), 
            RedisCacheConfiguration.defaultCacheConfig());
    }
}
