package com.wen.cloud.service;

import com.wen.cloud.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by 21up on 2020/7/12
 */
@Service
public class UserService {

    public User getUserById(String id) {
        User user = new User();
        user.setId("011");
        user.setUsername("21up");
        user.setPassword("123456");
        return user;
    }
}
