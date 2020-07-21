package com.wen.cloud.controller;

import com.wen.cloud.model.User;
import com.wen.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 21up on 2020/7/12
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        System.out.println("user-service");
        return userService.getUserById(id);
    }
}
