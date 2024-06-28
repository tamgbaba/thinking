package com.tang.thinking.common.filch;
@FunctionalInterface
public interface FunctionFilchCodeStrategy <T, R> {
    R apply(T t);

}
