package com.redis.redisdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

//@Component
public class RedisKeyExpiredInit implements CommandLineRunner {
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        redisTemplate.opsForValue().set("a", "1", 5, TimeUnit.SECONDS);

        Thread.sleep(6000);
    }
}
