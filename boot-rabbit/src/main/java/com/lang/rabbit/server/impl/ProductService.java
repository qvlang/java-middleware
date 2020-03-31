package com.lang.rabbit.server.impl;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@RabbitListener(queues = "queuec")
public class ProductService {

    @RabbitHandler
    public void lock(Map<String, Long> map, Channel channel, Message message) throws IOException {
        try {
            System.out.println(map.get("pid"));
            //根据商品id 修改商品状态
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
            System.out.println("消息确认" + message.getMessageProperties().getConsumerQueue() + ",收到了回调消息");
        } catch (IOException e) {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            //该消息出错 拒绝掉
            //TODO
            e.printStackTrace();
        }
    }
}
