package com.tank.conf;

import com.tank.annotation.EnableHello;
import com.tank.resource.YmlPropsSourceFactory;
import com.tank.service.db.DataSourceRegisterPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author tank198435163.com
 */

@Configuration
@PropertySource(value = "classpath:init.yml", factory = YmlPropsSourceFactory.class)
public class InitializerBean {

  @Bean
  public DataSourceRegisterPostProcessor initDataSourceRegisterPostProcessor() {
    return new DataSourceRegisterPostProcessor();
  }

  @Bean
  @EnableHello("welcome to china")
  public String sayHello() {
    return "hello,fuchun";
  }
}
