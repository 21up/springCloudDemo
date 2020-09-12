package com.wen.mall.tiny.component;

import com.wen.mall.tiny.dto.QueueEnum;
import com.wen.mall.tiny.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 取消订单消息的处理者
 * Created by 21up on 2020/9/9
 */
@Component
@RabbitListener(queues ="mall.order.cancel")
public class CancelOrderReceiver {
    private static Logger LOGGER= LoggerFactory.getLogger(CancelOrderReceiver.class);
    @Autowired
    private OmsPortalOrderService portalOrderService;
    @RabbitListener
    public void handle(Long orderId){
        LOGGER.info("receiver delay message orderId:{}"+orderId);
        portalOrderService.cancelOrder(orderId);
    }
}
