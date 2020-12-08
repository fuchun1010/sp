package com.tank;

import cn.hutool.crypto.digest.MD5;
import lombok.val;
import org.junit.Test;

/**
 * @author tank198435163.com
 */
public class CryptoTest {

  @Test
  public void cryptoStr() {
    val email = "fuchun@163.com";
    val content = email.getBytes();
    val result = MD5.create().digestHex(content);

    System.out.println(content.length);
  }
}
