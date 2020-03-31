package com.lang.rabbit.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class ApplicationConfig {

    //注入exchange
    @Bean
    public Exchange directExchange() {
        return new DirectExchange("course", true, false);
    }

    //注入队列
    @Bean
    public Queue queuec() {
        return new Queue("queuec", true, false, false);
    }

    //注入绑定
    @Bean
    public Binding binding() {
        return new Binding("queuec", Binding.DestinationType.QUEUE, "course", "qc", null);
    }

    //注入消息转化器
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yy-MM-dd HH-mm-ss"));
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
