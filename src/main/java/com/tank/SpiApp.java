package com.tank;

import cn.hutool.core.util.ObjectUtil;
import com.google.common.collect.Lists;
import com.tank.service.Pen;
import com.tank.spike.Person;
import io.vavr.collection.Stream;
import lombok.NonNull;
import lombok.val;

import java.util.ServiceLoader;

/**
 * @author tank198435163.com
 */
public class SpiApp {

  public static void main(@NonNull final String[] args) {
    val spiLoader = ServiceLoader.load(Pen.class);
    for (Pen result : spiLoader) {
      System.out.println(result.getClass().getName());
    }

    val person = new Person();
    val persons = Lists.newArrayList();
    for (int i = 0; i < 100; i++) {
      val tmp = ObjectUtil.<Person>cloneByStream(person);
      tmp.setJob(String.valueOf(i));
      persons.add(tmp);
    }

    Stream.ofAll(persons).map(p -> (Person) p).forEach(System.out::println);


  }
}
