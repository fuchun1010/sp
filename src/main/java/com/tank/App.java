package com.tank;

import com.tank.service.MemberService;
import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author tank198435163.com
 */
public class App {
  public static void main(final String[] args) {
    val scannerPackages = new String[]{"com.tank.**"};
    val context = new AnnotationConfigApplicationContext(scannerPackages);
    val memberService = context.getBean(MemberService.class);
    val result = memberService.register();
    System.out.println(result);
    context.close();

    
  }

}
