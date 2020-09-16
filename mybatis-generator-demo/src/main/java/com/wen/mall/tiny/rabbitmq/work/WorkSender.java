package com.wen.mall.tiny.rabbitmq.work;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 21up on 2020/9/16
 */
public class WorkSender {
    private static final Logger LOGGER= LoggerFactory.getLogger(WorkSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final String queueName="work.hello";
    public void send(int index){
        StringBuilder builder = new StringBuilder("hello");
        int limitIndex=index%3+ 1;
        for (int i=0;i<limitIndex;i++){
            builder.append(".");
        }
        builder.append(index+1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend(queueName,message);
        LOGGER.info("[X] Sent '{}'",message);
    }
}
