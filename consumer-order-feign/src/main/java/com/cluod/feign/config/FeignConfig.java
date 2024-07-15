package com.cluod.feign.config;

import com.cluod.commons.exp.CustomErrorDecoder;
import feign.Logger;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: FeignConfig
 * @Author David
 * @Package com.cluod.feign.controller.config
 * @Date 2024/7/12 下午4:28
 * @description: OpenFeign的配置类
 */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer myRetryer() {

        //return Retryer.NEVER_RETRY; //Feign默认配置是不走重试策略的
        //最大请求次数为3(1+2)，初始间隔时间为100ms，重试间最大间隔时间为1s
        return new Retryer.Default(100, 1, 3);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}
