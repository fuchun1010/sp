package com.tank.event;

import lombok.NonNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author tank198435163.com
 */
@Component
public class ReceivedService implements ApplicationEventPublisherAware {

  private ApplicationEventPublisher publisher = null;

  public void received(@NonNull final String json) {
    this.publisher.publishEvent(new CustomerEvent<String>(json));
  }

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
    this.publisher = publisher;
  }
}
