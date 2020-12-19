package com.tank.conf;

import com.tank.annotation.DataFrom;
import lombok.NonNull;
import lombok.val;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

/**
 * @author tank198435163.com
 */
public class DataFromCondition implements Condition {

  @Override
  public boolean matches(@NonNull final ConditionContext context,
                         @NonNull final AnnotatedTypeMetadata metadata) {
    val annotations = metadata.getAnnotationAttributes(DataFrom.class.getName());
    val isEmpty = Objects.isNull(annotations) || annotations.isEmpty();
    if (isEmpty) {
      return false;
    }
    val results = annotations.get("value");
    return Objects.nonNull(results) && "redis".equals(results.toString());
  }
}
