package com.wen.mall.tiny.rabbitmq.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * Created by 21up on 2020/9/16
 */
@RabbitListener(queues = "simple.hello")
public class SimpleReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleReceiver.class);
    @RabbitListener
    public void receive(String in){
        LOGGER.info("[x] Received '{}'",in);
    }
}
