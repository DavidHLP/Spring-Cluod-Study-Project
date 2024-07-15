package com.cluod.commons.exp;

import com.cluod.commons.resp.ResultData;
import com.cluod.commons.resp.ReturnCodeEnum;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Title: GlobalExceptionHandler
 * @Author David
 * @Package com.cloud.payment.exp
 * @Date 2024/7/8 下午3:23
 * @description: 用于处理全局异常
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ResultData<String> handleFeignException(FeignException e) {
        log.error("Feign异常信息: {}", e.getMessage(), e);
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "Feign客户端异常：" + e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> handleRuntimeException(RuntimeException e) {
        log.error("全局异常信息: {}", e.getMessage(), e);
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}
