package com.tank.conf;

import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author tank198435163.com
 */
@Component
public class CustomerEvent {

  @EventListener
  public void received(PayloadApplicationEvent<String> event) {
    System.out.println("event = " + event.getPayload());
  }
}
