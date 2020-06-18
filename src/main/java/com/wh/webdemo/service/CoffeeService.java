package com.wh.webdemo.service;

import com.wh.webdemo.controller.request.NewCoffeeRequest;
import com.wh.webdemo.model.Coffee;
import com.wh.webdemo.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

/**
 * @author 28476 wanghao <a href="hao.wang@1hai.cn">Contact me.</a>
 * @version 1.0
 * @since 2020/06/04 10:13
 * desc :
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "coffee")
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @Cacheable
    public List<Coffee> findAllCoffee() {
        return coffeeRepository.findAll();
    }

    /**
     * 用于利用aop重载缓存
     */
    @CacheEvict
    public void reloadCoffee() {

    }

    public Optional<Coffee> findOneCoffee(String name){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name",exact().ignoreCase());
        Optional<Coffee> coffee = coffeeRepository.findOne(
                Example.of(Coffee.builder().name(name).build(),matcher)
        );
        log.info("Coffee Found: {}", coffee);
        return coffee;
    }

    public List<Coffee> getCoffeeByName(List<String> names) {
        return coffeeRepository.findByNameInOrderById(names);
    }

    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll();
    }

    public Coffee getCoffee(String name) {
        return coffeeRepository.getByName(name);
    }

    public Coffee getCoffee(Long id) {
        return coffeeRepository.getOne(id);
    }

    public Coffee saveCoffee(NewCoffeeRequest newCoffee) {
        return coffeeRepository.save(new Coffee(newCoffee.getName(),newCoffee.getPrice()));
    }

    public Coffee saveCoffee(String s, Money cny) {
        return coffeeRepository.save(new Coffee(s,cny));
    }
}
