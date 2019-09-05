package com.funtl.hello.spring.cloud.web.admin.feign.service;

import com.funtl.hello.spring.cloud.web.admin.feign.service.hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign把service设置为接口
 */

@FeignClient(value = "hello-spring-cloud-service-admin",fallback = AdminServiceHystrix.class)  //service 的注解为FeignClient 里面写服务提供者的name  fallback熔断调用的类
public interface AdminService {

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message);  //必须加上RequestParam注解  不然报405c错误
}
