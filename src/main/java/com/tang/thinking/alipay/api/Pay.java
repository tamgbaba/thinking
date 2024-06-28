package com.tang.thinking.alipay.api;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Getter
@Setter
@ConfigurationProperties(prefix = "payment.alipay")
public class Pay {
    //支付宝网关地址
    private String gatewayAddress;
    //websocket服务地址
    private String websocketAddress;
    //应用ID
    private String appId;
    //应用私钥
    private String appPrivateKey;
    //应用公钥
    private String appPublicKey;
    //支付宝公钥
    private String alipayPublicKey;
    //异步通知路径
    private String notifyUrl;
    //
    private String returnUrl;
    //应用名称
    private String appName;
    //merchantPid
    private String merchantPid;
    //应用密钥加密方式
    private String encryptionType;

}
