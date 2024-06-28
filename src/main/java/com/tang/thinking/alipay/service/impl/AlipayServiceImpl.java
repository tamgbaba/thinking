package com.tang.thinking.alipay.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.tang.thinking.alipay.api.Pay;
import com.tang.thinking.alipay.service.AlipayService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class AlipayServiceImpl implements AlipayService {

    private Pay pay;

    private AlipayConfig alipayConfig;

    @Override
    public void alipay(String orderNumber, HttpServletResponse httpResponse) throws IOException {
        AlipayClient alipayClient = new DefaultAlipayClient(pay.getGatewayAddress(), pay.getAppId(), pay.getAppPrivateKey(), "JSON", "utf-8", pay.getAlipayPublicKey(), pay.getEncryptionType());
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setNotifyUrl(pay.getNotifyUrl());

        JSONObject param = new JSONObject();
        param.put("out_trade_no", uuid());

        param.put("total_amount", money());//订单总金额
        param.put("subject", orderNumber);//订单标题
        param.put("product_code", "FAST_INSTANT_TRADE_PAY");
        //param.put("qr_pay_mode", orderNumber);
        request.setBizContent(param.toJSONString());
        String form = "";
        try {
            // 调用SDK生成表单
            form = alipayClient.pageExecute(request).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=utf-8");
        // 直接将完整的表单html输出到页面
        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    private String uuid() {
        UUID uuid = UUID.randomUUID();
        return String.valueOf(uuid).replaceAll("-", "");
    }

    private double money() {
        Random random = new Random();
        double money = random.nextDouble() * 10000;
        return Math.round(money * 100.0) / 100.0;
    }


    /**
     * 回调
     */
    @Override
    public String payNotify(HttpServletRequest request)  {
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(JSONObject.toJSONString(parameterMap));

        return null;
    }

    @Autowired
    public void setPay(Pay pay) {
        this.pay = pay;
    }

    @Autowired
    public void setAlipayConfig(AlipayConfig alipayConfig) {
        this.alipayConfig = alipayConfig;
    }
}




