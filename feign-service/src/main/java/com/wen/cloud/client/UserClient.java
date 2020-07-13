package com.wen.cloud.client;

import com.wen.cloud.client.fallback.UserFallbackService;
import com.wen.cloud.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service",fallback = UserFallbackService.class)
public interface UserClient {
    @GetMapping("user/{id}")
     User getUserById(@PathVariable("id") String id);
}
