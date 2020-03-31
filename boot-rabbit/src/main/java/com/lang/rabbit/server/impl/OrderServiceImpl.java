package com.lang.rabbit.server.impl;

import com.lang.rabbit.server.IOrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * @Description: 生成订单 后通知锁住库存
     * @Param:
     * @return:
     */
    @Override
    public boolean createOrder(Long pid, Long cid) {
        Map<String, Long> map = new HashMap();
        map.put("pid", pid);
        //有订单生成
        rabbitTemplate.convertAndSend("course", "qc", map);
        return false;
    }
}
