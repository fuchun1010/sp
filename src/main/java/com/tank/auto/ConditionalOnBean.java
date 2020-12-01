package com.tank.auto;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author tank198435163.com
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(BeansCondition.class)
public @interface ConditionalOnBean {
  String[] beansName();
}
