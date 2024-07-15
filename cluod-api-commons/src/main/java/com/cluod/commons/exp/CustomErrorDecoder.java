package com.cluod.commons.exp;

import feign.Request.HttpMethod;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

/**
 * @Title: CustomErrorDecoder
 * @Author: David
 * @Package: com.cluod.commons.exp
 * @Date: 2024/7/12 下午5:33
 * @Description: 自定义错误解码器类，用于处理Feign客户端的错误响应。
 * 当服务返回错误响应时，将其包装为RetryableException以触发重试机制。
 */

public class CustomErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        // 包装为 RetryableException 以触发重试
        return new RetryableException(
                response.status(),       // 错误状态码
                response.reason(),       // 错误原因
                HttpMethod.GET,          // 使用 GET 方法，或者使用 response.request().httpMethod() 方法获取
                (Long) null,             // 重试间隔时间，这里为 null
                response.request()       // 原始请求信息
        );
    }
}
