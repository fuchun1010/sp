package com.tank;

import com.tank.auto.Boss;
import com.tank.enumer.DataAccessEnum;
import com.tank.spike.ContextAware;
import io.vavr.Function1;
import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @author tank198435163.com
 */
public class App {
  public static void main(final String[] args) {
    final String[] packages = new String[]{"com.tank.**"};
    val context = new AnnotationConfigApplicationContext(packages);
    Map<DataAccessEnum, Function1<String, List<String>>> accessResolver = (Map<DataAccessEnum, Function1<String, List<String>>>) context.getBean("accessResolver");
    List<String> users = accessResolver.get(DataAccessEnum.Rdb).apply("jack");
    users.forEach(System.out::println);
    val db = context.getBean("db");
    System.out.println("db = " + db);
    val contextAware = context.getBean(ContextAware.class);
    contextAware.printBeanDefinition();
    val boss = context.getBean(Boss.class);
    boss.sayHello();
    context.close();
  }
}
