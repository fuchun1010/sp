package com.tank.inspector;

import cn.hutool.core.util.ArrayUtil;
import com.tank.anno.RedisLock;
import lombok.val;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author tank198435163.com
 */
@Aspect
@Component
public class RedisInterceptor {

  @Before("@annotation(com.tank.anno.RedisLock)")
  public void tryRedisLockInterceptor(JoinPoint joinPoint) {
    if (Objects.isNull(joinPoint)) {
      return;
    }
    val parameters = joinPoint.getArgs();
    if (ArrayUtil.isEmpty(parameters)) {
      return;
    }
    final RedisService tmp = ((RedisService) joinPoint.getThis());
    MethodSignature methodSignature = ((MethodSignature) joinPoint.getSignature());
    RedisLock redisLockAnnotation = methodSignature.getMethod().getAnnotation(RedisLock.class);
    val expiredTime = redisLockAnnotation.expired();
    val key = redisLockAnnotation.key().equalsIgnoreCase("-") ? "x" : redisLockAnnotation.key();
    tmp.tryLock(key, expiredTime);
    System.out.println("tryRedisLockInterceptor = ");
  }


  @DeclareParents(value = "com.tank.service.AccountService", defaultImpl = DefualtRedisService.class)
  private RedisService redisService;
}
