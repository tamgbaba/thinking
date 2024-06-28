package com.tang.thinking.alipay.service;

import com.alipay.api.AlipayApiException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AlipayService {
    void alipay(String orderNumber, HttpServletResponse httpResponse) throws IOException;

    String payNotify(HttpServletRequest request) throws AlipayApiException;

}
