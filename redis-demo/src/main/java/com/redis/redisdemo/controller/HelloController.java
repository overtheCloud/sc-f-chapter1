package com.redis.redisdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/hello")
    public long saveDateToRedis(@RequestParam String startTime, @RequestParam String endTime) {

        LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter);

        Duration duration = Duration.between(startDateTime, endDateTime);
        redisTemplate.opsForValue().set(startDateTime.toString(), endDateTime.toString(), duration.toMillis(), TimeUnit.MILLISECONDS);

        return duration.toMillis();
    }
}
