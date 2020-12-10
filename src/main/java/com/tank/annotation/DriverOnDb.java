package com.tank.annotation;

import com.tank.conf.OnConditionalDbDriver;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author tank198435163.com
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Conditional({OnConditionalDbDriver.class})
public @interface DriverOnDb {
  String value();
}
