package com.wen.mall.tiny.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.wen.mall.tiny.common.api.CommonResult;
import com.wen.mall.tiny.rabbitmq.simple.SimpleSender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 21up on 2020/9/16
 */
@Controller
@Api(tags = "RabbitController", description = "RabbitMQ功能测试")
public class RabbitController {
    @Autowired
    private SimpleSender simpleSender;
    @ApiOperation("简单模式")
    @RequestMapping(value = "/simple",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult simTest(){
        for (int i=0;i<10;i++){
            simpleSender.send();
            ThreadUtil.sleep(100);
        }
        return CommonResult.success(null);
    }
}