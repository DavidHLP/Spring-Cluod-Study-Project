package com.cloud.payment.controller;

import com.cloud.payment.entities.Pay;
import com.cloud.payment.entities.PayDTO;
import com.cloud.payment.service.PayService;
import com.cluod.commons.resp.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Title: PayController
 * @Author David
 * @Package com.cloud.payment.controller
 * @Date 2024/7/8 下午12:30
 * @description: Pay
 */

@RestController
@Tag(name = "支付微服务模块", description = "支付CRUD")
public class PayController {
    @Resource
    PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增", description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值：" + i);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除", description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        int i = payService.delete(id);
        return ResultData.success(i);
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改", description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值：" + i);
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID查流水", description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        if (id < 0) throw new RuntimeException("id不能为负数");

        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/get/all")
    @Operation(summary = "查询所有支付记录", description = "查询所有支付流水方法")
    public ResultData<List<Pay>> getAllById() {
        List<Pay> res = payService.getAll();
        return ResultData.success(res);
    }

    @GetMapping(value = "/pay/get/timeout")
    @Operation(summary = "测试超时", description = "测试超时")
    public String timeout(@Value("${custom.data}") String res , @Value("${server.port}") String port) {
        return res + " " + "Port:" + port;
    }

}
