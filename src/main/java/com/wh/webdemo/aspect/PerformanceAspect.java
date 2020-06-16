package com.wh.webdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 28476 wanghao <a href="hao.wang@1hai.cn">Contact me.</a>
 * @version 1.0
 * @since 2020/06/15 10:56
 * desc : 类的
 */

@Aspect
@Component
@Slf4j
public class PerformanceAspect {

    @Around("execution(* com.wh.webdemo.repository..*(..))")
    public Object logPerformance(ProceedingJoinPoint pjp) throws  Throwable {
        long startTime = System.currentTimeMillis();
        String name = "-";
        String result = "Y";
           try {
               name = pjp.getSignature().toShortString();
               return pjp.proceed();
           }catch (Throwable t){
               result = "N";
               throw t;
           } finally {
               long endTime = System.currentTimeMillis();
               log.info("!!!{};{};{}ms", name, result, endTime - startTime);
           }
    }

}
