package com.tank.inspector;

import lombok.NonNull;

public interface RedisService {

  boolean tryLock(@NonNull final String key,@NonNull final Integer expiredTime);
}
