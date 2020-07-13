package com.wen.cloud.controller;

import com.wen.cloud.client.UserClient;
import com.wen.cloud.model.User;
import com.wen.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 21up on 2020/7/13
 */
@RestController
@RequestMapping("feign/user")
public class UserFeignController implements UserClient{
    @Autowired
    private UserClient userClient;
    @Override
    @GetMapping("{id}")
    public User getUserById(@PathVariable String id) {
        return userClient.getUserById(id);
    }
}
