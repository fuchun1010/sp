package com.tank.conf;

import cn.hutool.core.util.StrUtil;
import com.tank.annotation.ConditionalOnDb;
import io.vavr.control.Try;
import lombok.NonNull;
import lombok.val;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

/**
 * @author tank198435163.com
 */
public class OnConditionalDbDriver implements Condition {

  @Override
  public boolean matches(@NonNull final ConditionContext conditionContext,
                         @NonNull final AnnotatedTypeMetadata annotatedTypeMetadata) {
    val annotationAttributes = annotatedTypeMetadata.getAnnotationAttributes(ConditionalOnDb.class.getName());
    if (Objects.isNull(annotationAttributes)) {
      return false;
    }
    val result = annotationAttributes.get("value");
    if (Objects.isNull(result)) {
      return false;
    }
    String className = ((String) result);

    if (StrUtil.isEmptyIfStr(className)) {
      return false;
    }

    return Try.of(() -> {
      Class.forName(className);
      return true;
    }).getOrElse(false);

  }
}
