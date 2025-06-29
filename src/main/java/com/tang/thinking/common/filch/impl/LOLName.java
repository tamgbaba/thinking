package com.tang.thinking.common.filch.impl;

import com.tang.thinking.common.filch.FilchCodeStrategy;
import com.tang.thinking.filch.service.FilchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.regex.Pattern;


@Component
public class LOLName implements FilchCodeStrategy {
    private static final String CHINA_LOL_NAME_NUMBER_REGEX = "/^u4e00-u9fa5a-zA-Z {2,17}/";

    @Autowired
    @Lazy
    private FilchService filterService;

    @Override
    public boolean isCode(String code) {
        return Pattern.compile(CHINA_LOL_NAME_NUMBER_REGEX).matcher(code).matches();
    }

    @Override
    public Map<String, Object> execute(String name) {
        return filterService.lolName(name);
    }
}
