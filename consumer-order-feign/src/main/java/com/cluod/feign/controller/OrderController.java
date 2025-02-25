package com.cluod.feign.controller;

import com.cluod.commons.api.PayFeignApi;
import com.cluod.commons.entities.PayDTO;
import com.cluod.commons.resp.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: controller
 * @Author David
 * @Package com.cluod.order
 * @Date 2024/7/9 下午3:34
 * @description:
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private PayFeignApi payFeignApi;

    @PostMapping("/feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        System.out.println("第一步：模拟本地addOrder新增订单成功(省略sql操作)，第二步：再开启addPay支付微服务远程调用");
        ResultData resultData = payFeignApi.addPay(payDTO);
        return resultData;
    }

    @GetMapping("/feign/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        System.out.println("-------支付微服务远程调用，按照id查询订单支付流水信息");
        ResultData resultData = payFeignApi.getPayInfo(id);
        return resultData;
    }

    /**
     * openfeign天然支持负载均衡演示
     *
     * @return
     */
    @GetMapping("/feign/pay/mylb")
    public String timeout() {
        return payFeignApi.timeout();
    }
}