package com.lang.rabbit.model;

import lombok.Data;

@Data
public class Customer {
    private Long customerID;
    private String customerName;
    private String gender;
    private String address;
}
