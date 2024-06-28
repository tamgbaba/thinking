package com.tang.thinking.common.filed.impl;

import com.tang.thinking.common.filed.FiledConvert;

public class FiledString implements FiledConvert {
    @Override
    public boolean isConvert(Class<?> filed) {
        return filed.equals(String.class);
    }

}
