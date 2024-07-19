package com.tang.thinking.client_info.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("clientInfo")
public class ClientInfoController {


    @GetMapping("ip")
    public Map<String, Object> getIp(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        result.put("X-Forwarded-For", request.getHeader("X-Forwarded-For"));
        result.put("Proxy-Client-IP", request.getHeader("Proxy-Client-IP"));
        result.put("WL-Proxy-Client-IP", request.getHeader("WL-Proxy-Client-IP"));
        result.put("HTTP_CLIENT_IP", request.getHeader("HTTP_CLIENT_IP"));
        result.put("HTTP_X_FORWARDED_FOR", request.getHeader("HTTP_X_FORWARDED_FOR"));
        result.put("RemoteAddr", request.getRemoteAddr());
        return result;
    }

}
