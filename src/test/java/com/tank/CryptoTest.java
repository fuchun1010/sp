package com.tank;

import cn.hutool.crypto.digest.MD5;
import com.tank.annotation.LoadToIoc;
import com.tank.beans.Bean;
import io.vavr.collection.Stream;
import lombok.val;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

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


  @Test
  public void testStr() {
    val f1 = new Reflections("com.tank", new TypeAnnotationsScanner(), new SubTypesScanner());
    val result = f1.getTypesAnnotatedWith(LoadToIoc.class);
    Stream.ofAll(result)
            .filter(item -> !item.getSimpleName().equals(Bean.class.getSimpleName()))
            .toList()
            .forEach(System.out::println);
  }


}
