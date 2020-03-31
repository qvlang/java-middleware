package com.lang.rabbit.server;

public interface IOrderService {
    //生成订单
    boolean createOrder(Long pid, Long cid);
}
