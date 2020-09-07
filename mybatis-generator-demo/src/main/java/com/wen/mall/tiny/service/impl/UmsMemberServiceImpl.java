package com.wen.mall.tiny.service.impl;

import com.wen.mall.tiny.common.api.CommonResult;
import com.wen.mall.tiny.service.RedisService;
import com.wen.mall.tiny.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * Created by 21up on 2020/9/7
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService{
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;
    @Autowired
    private RedisService redisService;
    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i=0;i<6;i++){
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone,sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone,AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(),"获取验证码成功");
    }
    //对输入的验证码进行校验
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)){
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result){
            return CommonResult.success(null,"验证码校验成功");
        }else {
            return CommonResult.failed("验证码不正确");
        }
    }
}
