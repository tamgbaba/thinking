package com.tang.thinking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ThinkingApplication {

    public static void main(String[] args) {
            SpringApplication.run(ThinkingApplication.class, args);
    }

    @RequestMapping("/")
    public String thinking(){
        return "墨竹出品必属精品";
    }
}
