package com.sky.boot;

import com.sky.boot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootTest
class SpringbootRedisApplicationTests {

    @Autowired
    @Qualifier(value = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        // redisTemplate.setKeySerializer(redisSerializer);
        // redisTemplate.setValueSerializer(redisSerializer);
        // redisTemplate.setHashKeySerializer(redisSerializer);
        // redisTemplate.setHashValueSerializer(redisSerializer);
        User user = new User("测试", "123456");

        redisTemplate.opsForValue().set("password", user.getPassword());
    }

}
