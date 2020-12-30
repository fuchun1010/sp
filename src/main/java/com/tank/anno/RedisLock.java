package com.tank.anno;

import java.lang.annotation.*;

/**
 * @author tank198435163.com
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisLock {

  int expired() default 100;

  String key() default "-";

}
