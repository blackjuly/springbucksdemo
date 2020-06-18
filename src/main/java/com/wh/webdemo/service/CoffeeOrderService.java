package com.wh.webdemo.service;

import com.wh.webdemo.model.Coffee;
import com.wh.webdemo.model.CoffeeOrder;
import com.wh.webdemo.model.OrderState;
import com.wh.webdemo.repository.CoffeeOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 28476 wanghao <a href="hao.wang@1hai.cn">Contact me.</a>
 * @version 1.0
 * @since 2020/06/04 10:23
 * desc :
 */
@Slf4j
@Service
//todo 事务？？ 不开事务时，lazyInit 报错 （懒加载模式下，会报错）
public class CoffeeOrderService {
    @Autowired
   private CoffeeOrderRepository orderRepository;

   public CoffeeOrder createOrder(String customer , Coffee...coffee) {
        CoffeeOrder order = CoffeeOrder.builder()
                .customer(customer)
                .items(new ArrayList<>(Arrays.asList(coffee)))
                .state(OrderState.INIT)
                .build();
        CoffeeOrder saved = orderRepository.save(order);
       log.info("New Order: {}", saved);
        return saved;
   }

   public boolean updateState(CoffeeOrder order,OrderState state){
       if (state.compareTo(order.getState()) <= 0){
           log.warn("wrong State order:{},{}",state,order.getState());
           return false;
       }
       order.setState(state);
       orderRepository.save(order);
       log.info("Updated Order: {}", order);
       return true;
   }

    public CoffeeOrder get(Long id) {
        return orderRepository.getOne(id);
    }
}
