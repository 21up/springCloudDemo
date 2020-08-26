package com.wen.cloud.controller;

import com.wen.cloud.domain.CommonResult;
import com.wen.cloud.domain.Order;
import com.wen.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 21up on 2020/8/26
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    /**
     * 创建订单
     */
    @GetMapping("/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult("订单创建成功！",200);
    }
}
