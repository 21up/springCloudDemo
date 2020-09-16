package com.wen.mall.tiny.rabbitmq.work;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by 21up on 2020/9/16
 */
@Configuration
public class WorkRabbitConfig {
    @Bean
    public Queue workQueue(){
        return new Queue("work.hello");
    }
    @Bean
    public WorkReceiver workReceiver1() {
        return new WorkReceiver(1);
    }

    @Bean
    public WorkReceiver workReceiver2() {
        return new WorkReceiver(2);
    }

    @Bean
    public WorkSender workSender() {
        return new WorkSender();
    }
}
