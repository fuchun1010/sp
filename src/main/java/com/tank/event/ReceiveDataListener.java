package com.tank.event;

import lombok.NonNull;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author tank198435163.com
 */
@Component
public class ReceiveDataListener {

  @EventListener
  public void writeRedis(@NonNull final CustomerEvent<String> data) {
    System.out.println("writeRedis");
  }

  @EventListener
  public void writeRdb(@NonNull final CustomerEvent<String> data) {
    System.out.println("writeRdb");
  }

}
