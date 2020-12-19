package com.tank;

import com.tank.service.component.UserProfile;
import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tank198435163.com
 */
public class App {
  public static void main(final String[] args) {
    final String[] packages = new String[]{"com.tank.**"};
    val context = new AnnotationConfigApplicationContext(packages);
    //Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
    val userProfile = context.getBean(UserProfile.class);
    val name = userProfile.getUserName();
  }
}
