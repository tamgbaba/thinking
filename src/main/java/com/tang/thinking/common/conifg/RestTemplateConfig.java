package com.tang.thinking.common.conifg;


import lombok.Setter;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import org.springframework.boot.context.properties.ConfigurationProperties;


@Configuration
@ConfigurationProperties(prefix = "common.rest-template")
@Setter
public class RestTemplateConfig {

    //连接超时时间
    private int connectTimeout;
    //连接池最大连接数
    private int maxTotal;
    //同路由下最大连接数
    private int defaultMaxPerRoute;
    //连接池请求时间
    private int requestTimeout;
    /**
     * rest模板
     *
     * @return
     */
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
        // boot中可使用RestTemplateBuilder.build创建
        RestTemplate restTemplate = new RestTemplate();
        // 配置请求工厂
        restTemplate.setRequestFactory(clientHttpRequestFactory);
        return restTemplate;
    }


    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory(HttpClient httpClient) {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(httpClient);

        factory.setConnectTimeout(connectTimeout);

        factory.setConnectionRequestTimeout(requestTimeout);
        return factory;
    }

    @Bean
    public HttpClient httpClient(HttpClientConnectionManager poolingHttpClientConnectionManager) {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);
        return httpClientBuilder.build();
    }

    @Bean
    public HttpClientConnectionManager poolingHttpClientConnectionManager() {
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();

        poolingHttpClientConnectionManager.setMaxTotal(maxTotal);

        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);

        return poolingHttpClientConnectionManager;
    }

}
