package com.lang.rabbit.controller;

import com.lang.rabbit.server.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

    @Autowired
    private IOrderService service;

    @GetMapping("/rabbit")
    public String t() {
        service.createOrder(1l, 1l);
        return "aaa";
    }
}
