package com.lang.rabbit.component;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ConfirmMessageReach implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void initRabbitTemplate() {
        // 设置生产者消息确认
        rabbitTemplate.setConfirmCallback(this);

    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("消息是否正确到达" + b);
        if (b) {
            System.out.println("消息到达rabbitmq服务器");
        } else {
            System.out.println("消息可能未到达rabbitmq服务器");
        }
    }
}
