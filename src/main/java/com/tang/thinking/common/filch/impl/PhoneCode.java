package com.tang.thinking.common.filch.impl;


import com.tang.thinking.common.filch.FilchCodeStrategy;
import com.tang.thinking.filch.service.FilchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.regex.Pattern;

@Component
public class PhoneCode implements FilchCodeStrategy {

    private static final String CHINA_PHONE_NUMBER_REGEX = "^(1[3-9])\\d{9}$";


    @Autowired
    @Lazy
    private FilchService filterService;


    @Override
    public boolean isCode(String code) {
        return Pattern.compile(CHINA_PHONE_NUMBER_REGEX).matcher(code).matches();
    }

    @Override
    public Map<String, Object> execute(String phone) {
        return filterService.phone(phone);
    }
}
