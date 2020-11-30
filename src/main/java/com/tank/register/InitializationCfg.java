package com.tank.register;

import com.tank.spike.Pen;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tank198435163.com
 */
@Configuration
public class InitializationCfg {

  @Bean
  public Pen initPen() {
    return new Pen();
  }
}
