package com.wh.webdemo.repository;

import com.wh.webdemo.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 28476 wanghao <a href="hao.wang@1hai.cn">Contact me.</a>
 * @version 1.0
 * @since 2020/06/04 10:06
 * desc :
 */

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
