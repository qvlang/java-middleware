package com.lang.rabbit.model;

import lombok.Data;

@Data
public class Product {
    private Long productId;
    private String productName;
    private double productPrice;
    //产品状态 0 在售 1 卖出
    private int status;
}
