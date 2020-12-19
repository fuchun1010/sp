package com.tank.annotation;

import com.tank.conf.DataFromCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author tank198435163.com
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional({DataFromCondition.class})
public @interface DataFrom {
  String value();
}
