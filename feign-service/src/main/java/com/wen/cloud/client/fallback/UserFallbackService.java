package com.wen.cloud.client.fallback;

import com.wen.cloud.client.UserClient;
import com.wen.cloud.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by 21up on 2020/7/13
 */
@Component
public class UserFallbackService implements UserClient{
    @Override
    public User getUserById(@PathVariable String id) {
        User user = new User();
        user.setPassword("error");
        user.setUsername("error");
        user.setId(id);
        return user;
    }
}
