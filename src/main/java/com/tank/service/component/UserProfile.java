package com.tank.service.component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author tank198435163.com
 */
@Component
public class UserProfile {

  @Getter
  @Value("${user.name}")
  private String userName;
}
