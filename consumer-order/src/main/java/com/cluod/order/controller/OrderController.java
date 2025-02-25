package com.cluod.order.controller;

import com.cluod.commons.resp.ResultData;
import com.cluod.order.entities.PayDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    public static final String PaymentSrv_URL = "http://cloud-payment-service";//服务注册中心上的微服务名称
    @Resource
    private RestTemplate restTemplate;

    /**
     * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
     * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
     * 参数可以不添加@RequestBody
     *
     * @param payDTO
     * @return ResultData
     */
    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);
    }

    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class, id);
    }

    @GetMapping("pay/get/timeout")
    public String getPaymentTimeout() {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/timeout", String.class);
    }

//    @Resource
//    private DiscoveryClient discoveryClient;
//
//    @GetMapping("/consumer/discovery")
//    public String discovery() {
//        List<String> services = discoveryClient.getServices();
//        for (String element : services) {
//            System.out.println(element);
//        }
//
//        System.out.println("===================================");
//
//        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
//        for (ServiceInstance element : instances) {
//            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
//        }
//
//        return instances.get(0).getServiceId() + ":" + instances.get(0).getPort();
//    }


}
