package com.tang.thinking.alipay.controller;


import com.tang.thinking.alipay.service.AlipayService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("payment/alipay")
public class AlipayController {
    private AlipayService alipayService;


    @GetMapping("pay")
    public void alipay(HttpServletResponse httpResponse, String orderNumber) throws IOException {
        alipayService.alipay(orderNumber, httpResponse);
    }
    @PostMapping("/notify")  // 注意这里必须是POST接口
    public String payNotify(HttpServletRequest request) throws Exception {
      return  alipayService.payNotify(request);
    }


    @Autowired
    public void setAlipayService(AlipayService alipayService) {
        this.alipayService = alipayService;
    }

}
