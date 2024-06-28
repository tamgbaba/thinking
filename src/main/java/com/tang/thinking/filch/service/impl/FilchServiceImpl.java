package com.tang.thinking.filch.service.impl;

import com.tang.thinking.common.filch.FilchCodeStrategy;
import com.tang.thinking.common.utools.Transverter;
import com.tang.thinking.filch.pojo.FilchProperties;
import com.tang.thinking.filch.pojo.PersonInfo;
import com.tang.thinking.filch.service.FilchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service("filchService")
public class FilchServiceImpl implements FilchService {

    @Autowired
    private RestTemplate restTemplate;

    private final Transverter convert = Transverter.builder();

    @Autowired
    FilchProperties properties;

    @Autowired
    private List<FilchCodeStrategy> filchCodeStrategies;

    @Override
    public PersonInfo personInfo(String type, String code) {
        Map<String, Object> map = null;
        for (FilchCodeStrategy strategy : filchCodeStrategies) {
            if (strategy.isCode(code)) {
                map = strategy.execute(code);
                break;
            }
        }
        if (Objects.isNull(map)) return null;
        PersonInfo personInfo = convert.mapToPojo(map, PersonInfo.class);

        //处理联盟信息
        String qq = personInfo.getQq();
        Map<String, Object> lolInfo = qqLol(qq);
        personInfo.setLolServerName(String.valueOf(lolInfo.get("daqu")));
        personInfo.setLolName(String.valueOf(lolInfo.get("name")));

        //处理微博信息
        String phone = personInfo.getPhone();
        Map<String, Object> wbInfo = wbPhone(phone);
        personInfo.setWbId(String.valueOf(wbInfo.get("id")));

        return personInfo;
    }

    @Override
    public Map<String, Object> qqApi(String qq) {
        return getBody(properties.getQqApiUrl() + qq);
    }


    @Override
    public Map<String, Object> phone(String phone) {
        Map<String, Object> body = getBody(properties.getPhoneApiUrl() + phone);
        if (body != null && body.size() > 0) {
            body.put("phone", phone);
        }
        return body;
    }

    @Override
    public Map<String, Object> qqLol(String qq) {
        return getBody(properties.getQqLolApiUrl() + qq);
    }

    @Override
    public Map<String, Object> lolName(String name) {
        return getBody(properties.getLolNameApiUrl() + name);
    }

    @Override
    public Map<String, Object> qqLm(String qq) {
        return getBody(properties.getQqLmApiUrl() + qq);
    }

    @Override
    public Map<String, Object> wbApi(String id) {
        return getBody(properties.getWbApiUrl() + id);
    }

    @Override
    public Map<String, Object> wbPhone(String phone) {
        return getBody(properties.getWbPhoneApiUrl() + phone);
    }


    private Map<String, Object> getBody(String url) {
        ResponseEntity<HashMap> forEntity = restTemplate.getForEntity(url, HashMap.class);
        if (forEntity.getStatusCode().value() == 200) {
            return forEntity.getBody();
        } else {
            throw new RuntimeException("服务器异常，获取信息失败");
        }
    }

}
