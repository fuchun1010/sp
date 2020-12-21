package com.tank.service;

import cn.hutool.core.util.StrUtil;
import com.tank.annotation.EnableHello;
import lombok.NonNull;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author tank198435163.com
 */
public class HelloOnCondition implements Condition {
  @Override
  public boolean matches(@NonNull final ConditionContext context,
                         @NonNull final AnnotatedTypeMetadata metadata) {
    final String value = ((String) metadata.getAnnotationAttributes(EnableHello.class.getName()).get("value"));
    return !StrUtil.isEmptyIfStr(value);
  }
}
