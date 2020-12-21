package com.tank.service;

import com.tank.annotation.EnableHello;
import com.tank.conf.InitializerBean;
import io.vavr.collection.Stream;
import lombok.val;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class HelloBeanDefPost implements BeanDefinitionRegistryPostProcessor {

  @Override
  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
    val methods = InitializerBean.class.getMethods();
    val targetMethod = Stream.of(methods).filter(method -> method.getName().equals("sayHello")).head();
    val value = targetMethod.getAnnotation(EnableHello.class).value();
    registry.removeBeanDefinition("sayHello");
    registry.registerBeanDefinition("sayHello",
            BeanDefinitionBuilder.rootBeanDefinition(String.class).addConstructorArgValue(value).getBeanDefinition());
    System.out.println("registry = ");
  }

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

  }
}
