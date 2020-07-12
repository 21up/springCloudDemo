package com.wen.cloud.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wen.cloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 21up on 2020/7/12
 */
@RestController
public class HystricController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.user-service}")
    private String serviceUrl;
    @GetMapping("testFallback/{id}")
    @HystrixCommand(fallbackMethod = "getDefaultUser")
    public User testFallback(@PathVariable String id){
        return restTemplate.getForObject(serviceUrl+"/user/{1}",User.class,id);
    }
    public User getDefaultUser(@PathVariable String id){
        User user = new User();
        user.setId("001");
        user.setUsername("error");
        user.setPassword("error");
        return user;
    }
}
