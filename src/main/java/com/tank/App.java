package com.tank;

import io.vavr.collection.Stream;
import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tank198435163.com
 */
public class App {
  public static void main(final String[] args) {
    final String[] packages = new String[]{"com.tank.**"};
    val context = new AnnotationConfigApplicationContext(packages);
//    Map<DataAccessEnum, Function1<String, List<String>>> accessResolver = (Map<DataAccessEnum, Function1<String, List<String>>>) context.getBean("accessResolver");
//    List<String> users = accessResolver.get(DataAccessEnum.Rdb).apply("jack");
//    users.forEach(System.out::println);
//    val db = context.getBean("db");
//    System.out.println("db = " + db);
//    val contextAware = context.getBean(ContextAware.class);
//    contextAware.printBeanDefinition();
//    val boss = context.getBean(Boss.class);
//    boss.sayHello();
//    context.close();
    Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
  }
}
