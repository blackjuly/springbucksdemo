package com.wh.webdemo;

import com.wh.webdemo.model.Coffee;
import com.wh.webdemo.model.CoffeeOrder;
import com.wh.webdemo.model.OrderState;
import com.wh.webdemo.repository.CoffeeOrderRepository;
import com.wh.webdemo.repository.CoffeeRepository;
import com.wh.webdemo.service.CoffeeOrderService;
import com.wh.webdemo.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;
import java.util.function.Consumer;

@Slf4j
//todo 事务管理 ？？
@EnableJpaRepositories
@SpringBootApplication
@EnableCaching(proxyTargetClass = true)
public class WebdemoApplication implements ApplicationRunner {

    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private CoffeeOrderService coffeeOrderService;

    public static void main(String[] args) {
        SpringApplication.run(WebdemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ALL COFFEE: {}", coffeeRepository.findAll().size());

        for (int i = 0; i < 5; i++) {
            log.info("Reading from cache.");
            coffeeService.findAllCoffee();
        }
        Thread.sleep(6000);
        log.info("reading after refresh");
        coffeeService.findAllCoffee().forEach(new Consumer<Coffee>() {
            @Override
            public void accept(Coffee coffee) {
                log.info("Coffee {}",coffee.getName());
            }
        });
        Optional<Coffee> latte = coffeeService.findOneCoffee("Latte");
        if (latte.isPresent()) {
			CoffeeOrder order = coffeeOrderService.createOrder("Li Lei",latte.get());
			log.info("Update INIT to PAID: {}", coffeeOrderService.updateState(order, OrderState.PAID));
			log.info("Update PAID to INIT: {}", coffeeOrderService.updateState(order, OrderState.INIT));
        }
    }

}
