package com.cluod.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@EnableDiscoveryClient
@SpringBootApplication
@RefreshScope // 动态刷新
public class SpringApplication8888 {
    public static void main(String[] args) {
        SpringApplication.run(SpringApplication8888.class, args);
    }
}