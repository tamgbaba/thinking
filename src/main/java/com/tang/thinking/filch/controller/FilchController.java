package com.tang.thinking.filch.controller;


import com.tang.thinking.filch.pojo.PersonInfo;
import com.tang.thinking.filch.service.FilchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("filch")
public class FilchController {


    @Autowired
    private FilchService service;

    @GetMapping("personInfo")
    public PersonInfo personInfo(@RequestParam(required = false, name = "type", defaultValue = "QQAPI") String type,
                                 @RequestParam(required = true, name = "code") String code) {
        return service.personInfo(type, code);
    }

    @GetMapping("qqapi")
    public Map<String, Object> qqApi(@RequestParam(required = true, name = "qq") String qq) {
        return service.qqApi(qq);
    }
}
