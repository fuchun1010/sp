package com.tank.inspector;

import lombok.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author tank198435163.com
 */
@Component
public class DefaultRedisServiceImpl implements RedisService {


  @Override
  public boolean tryLock(@NonNull String key, @NonNull Integer expiredTime) {
    return false;
  }
}
