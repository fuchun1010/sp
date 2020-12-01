package com.tank.auto;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class BeansCondition implements Condition {
  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    final Map<String, Object> anntions = metadata.getAnnotationAttributes(ConditionalOnBean.class.getName());
    anntions.get("");
    return false;
  }
}
