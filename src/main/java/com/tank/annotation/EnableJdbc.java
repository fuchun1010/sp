package com.tank.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/***
 * @author tank198435163.com
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, TYPE})
public @interface EnableJdbc {
}
