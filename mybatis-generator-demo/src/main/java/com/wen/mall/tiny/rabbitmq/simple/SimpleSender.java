package com.wen.mall.tiny.rabbitmq.simple;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 21up on 2020/9/16
 */
public class SimpleSender {
    private static final Logger LOGGER= LoggerFactory.getLogger(SimpleSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final String queueName="simple.hello";
    public void send(){
        String message="Hello Simple";
        rabbitTemplate.convertAndSend(queueName,message);
        LOGGER.info("[x] Sent '{}'",message);
    }
}
