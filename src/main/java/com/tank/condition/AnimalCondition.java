package com.tank.condition;

import com.tank.annotation.LoadToIoc;
import io.vavr.control.Try;
import lombok.val;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

/**
 * @author tank198435163.com
 */
public class AnimalCondition implements Condition {

  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    val target = metadata.getAnnotationAttributes(LoadToIoc.class.getName());
    return Try.of(() -> Objects.nonNull(target)).getOrElse(false);
  }
}
