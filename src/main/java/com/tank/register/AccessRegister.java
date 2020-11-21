package com.tank.register;

import com.google.common.collect.Maps;
import com.tank.enumer.DataAccessEnum;
import com.tank.service.impl.RdbAccessImpl;
import com.tank.service.impl.RedisAccessImpl;
import io.vavr.Function1;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author tank198435163.com
 */
@Configuration
@PropertySource("classpath:db.properties")
public class AccessRegister implements InitializingBean {

  @Override
  public void afterPropertiesSet() throws Exception {
    this.functions.putIfAbsent(DataAccessEnum.Rdb, this.rdbAccess::queryLatestOrders);
    this.functions.putIfAbsent(DataAccessEnum.Redis, this.redisAccess::queryLatestOrders);
  }

  @Bean("accessResolver")
  public Map<DataAccessEnum, Function1<String, List<String>>> registeredAccessResolver() {
    return this.functions;
  }

  @Bean("db")
  public String db() {
    return environment.getProperty("db");
  }

  private final Map<DataAccessEnum, Function1<String, List<String>>> functions = Maps.newConcurrentMap();

  @Resource(name = "rdbAccessImpl")
  private RdbAccessImpl rdbAccess;

  @Resource(name = "redisAccessImpl")
  private RedisAccessImpl redisAccess;

  @Resource
  private Environment environment;
}
