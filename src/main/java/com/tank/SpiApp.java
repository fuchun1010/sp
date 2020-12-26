package com.tank;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.val;

/**
 * @author tank198435163.com
 */
public class SpiApp {


  public static void main(@NonNull final String[] args) throws CloneNotSupportedException {
    val person = new Person();
    person.setName("lisi");
    person.setGender(Byte.valueOf("1"));

    val p1 = person.clone();
    val p2 = person.clone();
    System.out.println(p1 == p2);
    System.out.println("p1.name = " + p1.getName());
    System.out.println("p2.name = " + p2.getName());
    System.out.println("p1 = " + p1);
    System.out.println("p2 = " + p2);
  }


  @Getter
  @Setter
  private static class Person implements Cloneable {

    private String name;
    private Byte gender;

    @Override
    protected Person clone() throws CloneNotSupportedException {

      return (Person) (super.clone());
    }
  }
}
