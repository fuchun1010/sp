package com.tank.conf;

import com.alibaba.druid.pool.DruidDataSource;
import com.tank.annotation.DriverOnDb;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * @author tank198435163.com
 */
@Configuration
@PropertySource({"classpath:db.properties"})
public class InitializerBean {

  @Bean
  @DriverOnDb("com.mysql.cj.jdbc.Driver")
  public DruidDataSource initDataSource() {
    val dataSource = new DruidDataSource();
    dataSource.setUrl(this.environment.getProperty("url"));
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUsername(this.environment.getProperty("username"));
    dataSource.setPassword(this.environment.getProperty("password"));
    return dataSource;
  }

  @Resource
  private Environment environment;
}
