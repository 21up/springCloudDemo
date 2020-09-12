package com.wen.mall.tiny.dto;


import lombok.Getter;

@Getter
public enum QueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("mall.order.direct","mall.order.cancel","mall.order.cancel"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl", "mall.order.cancel.ttl", "mall.order.cancel.ttl");
    /**
     * 交换机名称
     */
    private  String exchangeName;
    /**
     * 队列名称
     */
    private String queueName;

    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchangeName, String queueName, String routeKey) {
        this.exchangeName = exchangeName;
        this.queueName = queueName;
        this.routeKey = routeKey;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public String getQueueName() {
        return queueName;
    }

    public String getRouteKey() {
        return routeKey;
    }
}
