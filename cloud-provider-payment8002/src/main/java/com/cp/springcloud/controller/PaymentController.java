package com.cp.springcloud.controller;

import com.cp.springcloud.entities.CommontResult;
import com.cp.springcloud.entities.Payment;
import com.cp.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommontResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        if (result > 0) {
            return new CommontResult(200, "插入成功，serverPort：" + serverPort, result);
        }
        return new CommontResult(444, "插入失败", null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommontResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommontResult(200, "查询成功，serverPort：" + serverPort, payment);
        }
        return new CommontResult(444, "没有记录，ID为：" + id, null);
    }

}
