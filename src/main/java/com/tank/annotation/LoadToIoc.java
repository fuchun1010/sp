package com.tank.annotation;

import java.lang.annotation.*;

/**
 * @author tank198435163.com
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoadToIoc {
}
