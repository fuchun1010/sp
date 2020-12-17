package com.tank.spike;

import lombok.NonNull;
import lombok.val;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import strman.Strman;

/**
 * @author tank198435163.com
 */
public class CustomerBeanDefinition implements ImportBeanDefinitionRegistrar, EnvironmentAware {

  @Override
  public void registerBeanDefinitions(@NonNull final AnnotationMetadata annotationMetadata,
                                      @NonNull final BeanDefinitionRegistry registry) {

    val person = BeanDefinitionBuilder.rootBeanDefinition(Person.class)
            .addPropertyValue("job", "driver")
            .addPropertyValue("gender", "male")
            .getBeanDefinition();

    registry.registerBeanDefinition(Strman.toCamelCase(Person.class.getSimpleName()), person);
  }

  @Override
  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }


  private Environment environment;
}
