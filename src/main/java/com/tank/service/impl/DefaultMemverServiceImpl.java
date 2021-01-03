package com.tank.service.impl;

import com.tank.service.MemberService;
import org.springframework.stereotype.Component;

/**
 * @author tank198435163.com
 */
@Component
public class DefaultMemverServiceImpl implements MemberService {
  @Override
  public boolean register() {
    System.out.println("register success");
    return true;
  }
}
