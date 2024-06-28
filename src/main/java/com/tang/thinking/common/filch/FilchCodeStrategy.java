package com.tang.thinking.common.filch;

import java.util.Map;

public interface FilchCodeStrategy {

    boolean isCode(String code);

    Map<String, Object> execute(String code);


}
