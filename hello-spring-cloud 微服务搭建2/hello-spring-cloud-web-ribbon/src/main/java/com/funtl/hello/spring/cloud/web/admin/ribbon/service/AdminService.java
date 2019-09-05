package com.funtl.hello.spring.cloud.web.admin.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service  //java配置 设置为一个服务
public class AdminService {

    @Autowired  //自动注入 （config已经配置了）
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "hiError")  //服务器连接失败返回熔断方法
    public String sayHi(String message){
        //消费者访问服务者   http+ 服务者的name(不要维护端口和ip了)
        return restTemplate.getForObject("http://HELLO-SPRING-CLOUD-SERVICE-ADMIN/hi?message="+message,String.class); //消费者访问提供者
    }

    //服务器连接失败提示（熔断方法）
    public String hiError(String message){
        return String.format("Hi you message is: %s but request bad",message);
    }
}
