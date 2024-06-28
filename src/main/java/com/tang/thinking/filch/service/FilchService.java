package com.tang.thinking.filch.service;

import com.tang.thinking.filch.pojo.PersonInfo;

import java.util.Map;

public interface FilchService {
    Map<String, Object> qqApi(String qq);

    Map<String, Object> phone(String phone);

    Map<String, Object> qqLol(String qq);

    Map<String, Object> lolName(String name);

    Map<String, Object> qqLm(String qq);

    Map<String, Object> wbApi(String id);

    Map<String, Object> wbPhone(String phone);

    PersonInfo personInfo(String type, String code);


}
