package com.tank.enumer;

import io.vavr.collection.Stream;
import io.vavr.control.Option;
import lombok.Getter;
import lombok.NonNull;


/**
 * @author tank198435163.com
 */
public enum DataAccessEnum {

  Redis("redis"), Rdb("rdb");


  DataAccessEnum(String type) {
    this.type = type;
  }

  public Option<DataAccessEnum> queryDataAccessEnum(@NonNull final String type) {
    return Stream.of(DataAccessEnum.values())
            .filter(enumType -> enumType.getType().equalsIgnoreCase(type))
            .headOption();
  }

  @Getter
  private String type;


}
