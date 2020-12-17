package com.tank.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author tank198435163.com
 */
public class CustomerEvent<T> extends ApplicationEvent {

  public CustomerEvent(T source) {
    super(source);
  }
}
