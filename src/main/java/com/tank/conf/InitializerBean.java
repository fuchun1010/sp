package com.tank.conf;

import com.tank.annotation.DataFrom;
import com.tank.service.db.DataSourceRegisterPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tank198435163.com
 */

@Configuration
public class InitializerBean {

  @Bean
  public DataSourceRegisterPostProcessor initDataSourceRegisterPostProcessor() {
    return new DataSourceRegisterPostProcessor();
  }


  @Bean
  @DataFrom("redis")
  public String initHello() {
    return "hello";
  }

}
