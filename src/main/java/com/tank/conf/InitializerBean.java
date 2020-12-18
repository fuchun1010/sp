package com.tank.conf;

import com.tank.condition.AnimalCondition;
import com.tank.service.db.DataSourceRegisterPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * @author tank198435163.com
 */

@Configuration
@PropertySource({"classpath:db.properties"})
@Conditional(AnimalCondition.class)
public class InitializerBean {

  @Bean
  public DataSourceRegisterPostProcessor initDataSourceRegisterPostProcessor() {
    return new DataSourceRegisterPostProcessor();
  }


  @Resource
  private Environment environment;
}
