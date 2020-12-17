package com.tank.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author tank198435163.com
 */
public class ReceivedData extends ApplicationEvent {

  public ReceivedData(String source) {
    super(source);
  }
}
