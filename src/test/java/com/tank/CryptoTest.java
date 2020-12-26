package com.tank;

import com.tank.annotation.LoadToIoc;
import com.tank.beans.Bean;
import io.vavr.collection.Stream;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

/**
 * @author tank198435163.com
 */
public class CryptoTest {

  @Test
  public void annotationTest() {
    val f1 = new Reflections("com.tank", new TypeAnnotationsScanner(), new SubTypesScanner());
    val result = f1.getTypesAnnotatedWith(LoadToIoc.class);
    Assert.assertNotNull(result);
    Stream.ofAll(result)
            .filter(item -> !item.getSimpleName().equals(Bean.class.getSimpleName()))
            .toList()
            .forEach(System.out::println);
  }


}
