package com.tank.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author tank198435163.com
 */
public class ReceivedData<T> extends ApplicationEvent {

  public ReceivedData(T source) {
    super(source);
  }
}
