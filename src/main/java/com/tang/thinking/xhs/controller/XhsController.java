package com.tang.thinking.xhs.controller;
import com.tang.thinking.xhs.service.XhsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/xhs")
public class XhsController {


    private XhsService xhsService;


    public XhsController(XhsService xhsService){
        this.xhsService =xhsService;
    }

    @GetMapping("getSign")
    private String  getSign(@RequestParam  Map<String,Object>params){
        return xhsService.getSign(params);
    }

}
