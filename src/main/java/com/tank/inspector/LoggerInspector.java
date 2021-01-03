package com.tank.inspector;

import cn.hutool.core.util.StrUtil;
import lombok.SneakyThrows;
import lombok.val;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author tank198435163.com
 */
@Aspect
@Component
public class LoggerInspector {

  @SneakyThrows
  @Around("execution(* com.tank.service.MemberService.*(..))")
  public Object before(ProceedingJoinPoint joinPoint) {
    val start = LocalDateTime.now();
    val result = joinPoint.proceed();
    val clazzName = joinPoint.getTarget().getClass().getName();
    final MethodSignature method = ((MethodSignature) joinPoint.getSignature());
    val end = LocalDateTime.now();
    val differ = Duration.between(start, end).toMillis();
    val tips = StrUtil.format("class name:[{}], method name:[{}], cost:[{}] millis",
            clazzName,
            method.getName(),
            differ);
    System.out.println("running info = " + tips);
    return result;
  }
}
