package com.tank.conf;

import com.tank.service.db.DataSourceRegisterPostProcessor;
import com.tank.spike.CustomerBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * @author tank198435163.com
 */
@Configuration
@PropertySource({"classpath:db.properties"})
@Import({CustomerBeanDefinition.class})
public class InitializerBean {

  @Bean
  public DataSourceRegisterPostProcessor initDataSourceRegisterPostProcessor() {
    return new DataSourceRegisterPostProcessor();
  }

  @Resource
  private Environment environment;
}
