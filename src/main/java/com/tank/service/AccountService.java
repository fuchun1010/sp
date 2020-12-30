package com.tank.service;

import com.tank.anno.RedisLock;
import org.springframework.stereotype.Component;

/**
 * @author tank198435163.com
 */
@Component
public class AccountService {

  @RedisLock(expired = 500)
  public void transfer(String account) {
    System.out.println("transfer");
  }
}
