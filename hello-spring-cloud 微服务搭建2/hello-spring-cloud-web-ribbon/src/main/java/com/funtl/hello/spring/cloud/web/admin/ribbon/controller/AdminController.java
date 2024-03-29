package com.funtl.hello.spring.cloud.web.admin.ribbon.controller;

import com.funtl.hello.spring.cloud.web.admin.ribbon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一个controller
 * 访问业务层
 * 回到传统的构建间模式
 */


//java配置为rest风格的controller
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String message){

        return adminService.sayHi(message);
    }
}
