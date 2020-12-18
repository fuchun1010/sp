package com.tank;

import com.tank.service.Pen;
import lombok.NonNull;
import lombok.val;

import java.util.ServiceLoader;

/**
 * @author tank198435163.com
 */
public class SpiApp {

  public static void main(@NonNull final String[] args) {
    val spiLoader = ServiceLoader.load(Pen.class);
    for (Pen result : spiLoader) {
      System.out.println(result.getClass().getName());
    }

  }
}
