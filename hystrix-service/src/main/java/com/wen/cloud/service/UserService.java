package com.wen.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.wen.cloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 21up on 2020/7/12
 */
public class UserService {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.user-service}")
    private String serviceUrl;

    @HystrixCommand(fallbackMethod = "getDefaultUser")
    public User testFallback(String id){
        return restTemplate.getForObject(serviceUrl+"/user/{1}",User.class,id);
    }
    public User getDefaultUser(@PathVariable String id){
        User user = new User();
        user.setId("error");
        user.setUsername("error");
        user.setPassword("error");
        return user;
    }
    @HystrixCommand(fallbackMethod = "getDefaultUser",
                    commandKey = "getUserCommand",
                    groupKey = "getUserGroup",
                    threadPoolKey = "getUserThreadPool")
    public User testCommand(String id) {
        return restTemplate.getForObject(serviceUrl+"/user/{1}",User.class,id);
    }
    @HystrixCommand(fallbackMethod = "getDefaultUser2",ignoreExceptions = {NullPointerException.class})
    public User testException(String id) {
        if ("1".equals(id)){
            throw new IndexOutOfBoundsException();
        }
        if ("2".equals(id)){
            throw new NullPointerException();
        }
        return restTemplate.getForObject(serviceUrl+"/user/{1}",User.class,id);
    }
    public User getDefaultUser2(@PathVariable String id, Throwable e) {
        User user = new User();
        user.setId("getDefaultUser2");
        user.setUsername("getDefaultUser2");
        user.setPassword("getDefaultUser2");
        return user;
    }
    @CacheResult(cacheKeyMethod = "getCacheKey")
    @HystrixCommand(fallbackMethod = "getDefaultUser",commandKey = "getUserCache")
    public User getUserCache(String id) {
        System.out.println("用户id"+id);
        return restTemplate.getForObject(serviceUrl+"/user/{1}",User.class,id);
    }
    public String getCacheKey(String id){
        return String.valueOf(id);
    }
}
