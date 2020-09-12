package com.wen.mall.tiny.service.impl;

import com.wen.mall.tiny.common.api.CommonResult;
import com.wen.mall.tiny.component.CancelOrderSender;
import com.wen.mall.tiny.dto.OrderParam;
import com.wen.mall.tiny.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 21up on 2020/9/9
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService{
    private static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);
    @Autowired
    private CancelOrderSender cancelOrderSender;
    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        //todo 执行一系类下单操作，具体参考mall项目
        LOGGER.info("process generateOrder");
        //下单完成后开启一个延迟消息，用于当用户没有付款时取消订单（orderId应该在下单后生成）
        sendDelayMessageCancelOrder(11L);
        return CommonResult.success(null, "下单成功");
    }

    private void sendDelayMessageCancelOrder(long orderId) {
        //获取订单超时时间，假设为30s
        long delayTimes = 3 * 1000;
        //发送延迟消息
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }

    @Override
    public void cancelOrder(Long orderId) {
        LOGGER.info("取消订单");
    }
}
