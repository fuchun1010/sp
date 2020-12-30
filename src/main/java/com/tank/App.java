package com.tank;

import com.tank.service.AccountService;
import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tank198435163.com
 */
public class App {
  public static void main(final String[] args) {
    val scannerPackages = new String[]{"com.tank.**"};
    val context = new AnnotationConfigApplicationContext(scannerPackages);
    val accountService = context.getBean(AccountService.class);
    accountService.transfer("key");
    context.close();
  }

}
