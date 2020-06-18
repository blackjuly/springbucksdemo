package com.wh.webdemo.controller;

import com.wh.webdemo.controller.request.NewOrderRequest;
import com.wh.webdemo.model.Coffee;
import com.wh.webdemo.model.CoffeeOrder;
import com.wh.webdemo.service.CoffeeOrderService;
import com.wh.webdemo.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 28476 wanghao <a href="hao.wang@1hai.cn">Contact me.</a>
 * @version 1.0
 * @since 2020/06/16 17:43
 * desc :
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class CoffeeOrderController {
    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private CoffeeOrderService orderService;

    @GetMapping("/{id}")
    public CoffeeOrder getOrder(@PathVariable("id") Long id){
        return orderService.get(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeOrder create(@RequestBody NewOrderRequest newOrder){
        log.info("receive new order {}",newOrder);
        Coffee[] coffeeList = coffeeService.getCoffeeByName(newOrder.getItems()).toArray(new Coffee[]{});
        final CoffeeOrder order = orderService.createOrder(newOrder.getCustomer(), coffeeList);
        return order;
    }
}
