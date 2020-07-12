package com.wen.cloud.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wen.cloud.model.User;
import com.wen.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 21up on 2020/7/12
 */
@RestController
@RequestMapping("user")
public class HystricController {

    @Autowired
    private UserService userService;
    @GetMapping("testFallback/{id}")
    public User testFallback(@PathVariable String id){
        return userService.testFallback(id);
    }
    @GetMapping("testCommand/{id}")
    public User testCommand(@PathVariable String id){
        return userService.testCommand(id);
    }
}
