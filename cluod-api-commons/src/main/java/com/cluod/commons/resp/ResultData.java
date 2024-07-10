package com.cluod.commons.resp;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Title: ResultData
 * @Author David
 * @Package com.cloud.payment.resp
 * @Date 2024/7/8 下午2:49
 * @description: 响应数据的格式化
 */
@Data
@Accessors(chain = true)
public class ResultData<T> {

    private String code;
    /**
     * 结果状态 ,具体状态码参见枚举类ReturnCodeEnum.java
     */
    private String message;
    private T data;
    private long timestamp;


    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> fail(String code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMessage(message);

        return resultData;
    }

}
