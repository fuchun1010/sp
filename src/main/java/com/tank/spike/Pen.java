package com.tank.spike;

import javax.annotation.PostConstruct;

/**
 * @author tank198435163.com
 */
public class Pen {

  @PostConstruct
  public void addSomeInk() {
    System.out.println("add some ink");
  }

}
