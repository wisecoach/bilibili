package com.wisecoach.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author wisecoach
 */
@Aspect
@Component
public class CacheAdvice {

    @Pointcut("@annotation(com.wisecoach.annotation.Cacheable),@target(com.wisecoach.annotation.Cacheable)")
    public void cache(){

    }

    @Around("cache()")
    public Object run1(ProceedingJoinPoint joinPoint) throws Throwable{
        joinPoint.toShortString();
        Object[] args = joinPoint.getArgs();
        return null;
    }

}
