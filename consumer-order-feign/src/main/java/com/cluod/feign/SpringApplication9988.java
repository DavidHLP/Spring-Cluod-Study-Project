package com.cluod.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @auther zzyy
 * @create 2023-11-09 15:12
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul为注册中心时注册服务
@EnableFeignClients(basePackages = "com.cluod.commons.api")
@ComponentScan(basePackages = {"com.cluod.feign.controller", "com.cluod.commons.exp"})
public class SpringApplication9988 {
    public static void main(String[] args) {
        SpringApplication.run(SpringApplication9988.class, args);
    }
}