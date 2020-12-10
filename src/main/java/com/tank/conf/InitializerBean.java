package com.tank.conf;

import com.tank.annotation.ConditionalOnDb;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tank198435163.com
 */
@Configuration

public class InitializerBean {

  @Bean
  @ConditionalOnDb("com.mysql.jdbc.Driver")
  public String initTestStr() {
    return "hello";
  }

}
