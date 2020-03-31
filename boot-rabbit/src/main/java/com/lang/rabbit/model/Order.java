package com.lang.rabbit.model;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Long orderId;
    private Long productId;
    private Long customerId;
    private Date createTime;
}
