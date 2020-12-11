package com.tank.service.db;

import com.alibaba.druid.pool.DruidDataSource;
import io.vavr.control.Try;
import lombok.val;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.sql.Driver;
import java.util.List;

/**
 * @author tank198435163.com
 */
@PropertySource("classpath:db.properties")
public class DataSourceRegisterPostProcessor implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {

  @Override
  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
    val beanDefinitionBuilder = BeanDefinitionBuilder
            .rootBeanDefinition(DruidDataSource.class)
            .addPropertyValue("username", this.environment.getProperty("username"))
            .addPropertyValue("password", this.environment.getProperty("password"))
            .addPropertyValue("url", this.environment.getProperty("url"));

    List<String> drivers = SpringFactoriesLoader.loadFactoryNames(Driver.class, Thread.currentThread().getContextClassLoader());

    for (String driver : drivers) {
      val isSuccess = Try.of(() -> {
        Class.forName(driver);
        return true;
      }).getOrElse(false);
      if (isSuccess) {
        beanDefinitionBuilder.addPropertyValue("driverClassName", driver);
        break;
      }
    }

    //register datasource
    registry.registerBeanDefinition("dataSource", beanDefinitionBuilder.getBeanDefinition());

  }

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

  }

  @Override
  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }

  private Environment environment;
}
