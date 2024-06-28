package com.tang.thinking.alipay.config;


import com.alipay.api.AlipayConfig;
import com.tang.thinking.alipay.api.Pay;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlipayConfiguration {

    @Bean
    public Pay pay() {
        return new Pay();
    }

    @Bean
    public AlipayConfig alipayConfig(Pay pay) {
        AlipayConfig alipay = new AlipayConfig();
        alipay.setAlipayPublicKey(pay.getAlipayPublicKey());
        alipay.setServerUrl(pay.getGatewayAddress());
        alipay.setAppId(pay.getAppId());
        alipay.setPrivateKey(pay.getAppPrivateKey());
        alipay.setFormat("json");
        alipay.setSignType(pay.getEncryptionType());
        alipay.setCharset("utf-8");
        return alipay;
    }
}
