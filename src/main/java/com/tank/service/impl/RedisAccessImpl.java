package com.tank.service.impl;

import com.tank.service.DataAccess;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author tank198435163.com
 */
@Component("redisAccessImpl")
public class RedisAccessImpl implements DataAccess {

  @Override
  public List<String> queryLatestOrders(@NonNull final String customerId) {
    return Collections.singletonList("jack");
  }

}
