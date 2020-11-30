package com.tank.auto;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author tank198435163.com
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import(Boss.class)
public @interface EnableTavern {
}
