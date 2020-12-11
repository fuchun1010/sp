package com.tank;

import com.tank.service.Pen;
import io.vavr.collection.Stream;
import lombok.val;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * @author tank198435163.com
 */
public class App {
  public static void main(final String[] args) {

    List<Pen> pens = SpringFactoriesLoader.loadFactories(Pen.class, Thread.currentThread().getContextClassLoader());

    final String[] packages = new String[]{"com.tank.**"};
    val context = new AnnotationConfigApplicationContext(packages);
    Stream.ofAll(pens).forEach(pen -> {
      val beanDefinition = BeanDefinitionBuilder
              .rootBeanDefinition(pen.getClass())
              .addPropertyValue(pen.getClass().getSimpleName(), pen)
              .getBeanDefinition();
      context.registerBeanDefinition(pen.getClass().getSimpleName(), beanDefinition);
    });


    Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
  }
}
