package com.wh.webdemo.repository;

import com.wh.webdemo.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 28476 wanghao <a href="hao.wang@1hai.cn">Contact me.</a>
 * @version 1.0
 * @since 2020/06/04 10:10
 * desc :
 */
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder,Long> {
}
