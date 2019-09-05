package com.funtl.hello.spring.cloud.web.admin.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean//相当于 spring-context的xml的bean注解
    @LoadBalanced  //开启负载均衡注解(访问负载均衡服务)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
