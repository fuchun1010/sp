package com.tank.annotation;

import com.tank.service.HelloOnCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author tank198435163.com
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(HelloOnCondition.class)
public @interface EnableHello {
  String value() default "";
}
