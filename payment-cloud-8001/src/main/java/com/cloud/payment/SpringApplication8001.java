package com.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient//该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@SpringBootApplication
@MapperScan("com.cloud.payment.mapper")
@ComponentScan(basePackages = {"com.cloud.payment.controller"})
@RefreshScope // 动态刷新
public class SpringApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(SpringApplication8001.class, args);
    }
}