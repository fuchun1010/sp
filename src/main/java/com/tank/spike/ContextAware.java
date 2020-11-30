package com.tank.spike;

import io.vavr.collection.Stream;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author tank198435163.com
 */
@Component
public class ContextAware implements ApplicationContextAware {

  @Override
  public void setApplicationContext(ApplicationContext context) throws BeansException {
    this.context = context;
  }

  public void printBeanDefinition() {
    Stream.of(this.context.getBeanDefinitionNames()).forEach(System.out::println);
  }

  private ApplicationContext context;
}
