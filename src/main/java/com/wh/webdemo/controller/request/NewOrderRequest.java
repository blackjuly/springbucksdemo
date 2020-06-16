package com.wh.webdemo.controller.request;

import lombok.ToString;

import java.util.List;

/**
 * @author 28476 wanghao <a href="hao.wang@1hai.cn">Contact me.</a>
 * @version 1.0
 * @since 2020/06/16 17:45
 * desc :
 */
@ToString
public class NewOrderRequest {
    private List<String> items;
    private String customer  ;

    public List<String> getItems() {
        return items;
    }

    public String getCustomer() {
        return customer;
    }
}
