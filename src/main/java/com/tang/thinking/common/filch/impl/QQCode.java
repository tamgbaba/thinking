package com.tang.thinking.common.filch.impl;


import com.tang.thinking.common.filch.FilchCodeStrategy;
import com.tang.thinking.common.filch.FunctionFilchCodeStrategy;
import com.tang.thinking.filch.service.FilchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.regex.Pattern;

@Component
public class QQCode implements FilchCodeStrategy {

    private static final String CHINA_QQ_NUMBER_REGEX = "[1-9][0-9]{4,14}";


    @Autowired
    @Lazy
    private FilchService filterService;


    @Override
    public boolean isCode(String code) {
        return Pattern.compile(CHINA_QQ_NUMBER_REGEX).matcher(code).matches();
    }

    @Override
    public Map<String, Object> execute(String qq) {
        FunctionFilchCodeStrategy<String, Map<String, Object>> function = (code) -> filterService.qqApi(code);
        return function.apply(qq);
    }
}
