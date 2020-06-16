package com.wh.webdemo.controller;

import com.wh.webdemo.controller.request.NewOrderRequest;
import com.wh.webdemo.model.Coffee;
import com.wh.webdemo.model.CoffeeOrder;
import com.wh.webdemo.service.CoffeeOrderService;
import com.wh.webdemo.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public CoffeeOrder create(@RequestBody NewOrderRequest newOrder){
        log.info("receive new order {}",newOrder);
        Coffee[] coffeeList = coffeeService.getCoffeeByName(newOrder.getItems()).toArray(new Coffee[]{});
        return orderService.createOrder(newOrder.getCustomer(),coffeeList);
    }
}
