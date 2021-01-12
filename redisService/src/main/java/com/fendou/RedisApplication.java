package com.fendou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: cjx
 * @Date: 2021-01-12 10:34
 * @Description;
 */
@SpringBootApplication
@EnableEurekaClient
public class RedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class,args);
    }
}
