package com.sky.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Administrator
 */
@Configuration
public class RedisConfig {

    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 初始化配置RedisTemplate模板  为了开发方便我们一般使用<String,Object>类型
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 设置redisTemplate连接工程
        template.setConnectionFactory(redisConnectionFactory);

        // 初始化String类型初始化对象
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();

        // Key设置String类型的序列化方式
        template.setKeySerializer(redisSerializer);
        // Hash Key设置 String类型的序列号方式
        template.setHashKeySerializer(redisSerializer);

        // value值设置String序列化方式
        template.setValueSerializer(redisSerializer);
        // HashValue值设置String序列化方式
        template.setHashValueSerializer(redisSerializer);

        template.afterPropertiesSet();
        return template;
    }
}
