package com.tank.spike;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author tank198435163.com
 */
@Getter
@Setter
public class Person implements Serializable {

  private String gender;

  private String job;


  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
            .add("gender", gender)
            .add("job", job)
            .toString();
  }
}
