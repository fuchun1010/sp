package com.tank;

import com.tank.annotation.EnableJdbc;
import io.vavr.collection.Stream;
import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

/**
 * @author tank198435163.com
 */
@EnableJdbc
public class App {
  public static void main(final String[] args) {
    final String[] packages = new String[]{"com.tank.**"};
    val context = new AnnotationConfigApplicationContext(packages);
    Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
  }
}
