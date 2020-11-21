package com.tank;

import com.tank.enumer.DataAccessEnum;
import io.vavr.Function1;
import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Map;

/**
 * @author tank198435163.com
 */
@ComponentScan
public class App {
  public static void main(final String[] args) {
    final String[] packages = new String[]{"com.tank.register", "com.tank.service"};
    val context = new AnnotationConfigApplicationContext(packages);
    Map<DataAccessEnum, Function1<String, List<String>>> accessResolver = (Map<DataAccessEnum, Function1<String, List<String>>>) context.getBean("accessResolver");
    List<String> users = accessResolver.get(DataAccessEnum.Rdb).apply("jack");
    users.forEach(System.out::println);
  }
}
