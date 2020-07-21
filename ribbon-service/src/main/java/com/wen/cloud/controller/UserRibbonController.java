package com.wen.cloud.controller;

/*import com.netflix.discovery.converters.Auto;*/
import com.wen.cloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 21up on 2020/7/12
 */
@RestController
@RequestMapping("ribbon_service/user")
public class UserRibbonController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.user-service}")
    private String userServiceUrl;
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        System.out.println("ribbon-service");
        return restTemplate.getForObject(userServiceUrl+"/user/{1}",User.class,id);
    }
}
