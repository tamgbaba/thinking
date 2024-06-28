package com.tang.thinking.filch.pojo;


import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "filch")
@Getter
@Setter
public class FilchProperties {
    private FilchProperties() {

    }

    private String qqApiUrl;

    private String phoneApiUrl;

    private String qqLolApiUrl;

    private String lolNameApiUrl;

    private String qqLmApiUrl;

    private String wbApiUrl;

    private String wbPhoneApiUrl;

}
