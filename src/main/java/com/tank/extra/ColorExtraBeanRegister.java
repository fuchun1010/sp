package com.tank.extra;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author tank198435163.com
 */
public class ColorExtraBeanRegister implements ImportBeanDefinitionRegistrar {

  @Override
  public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
    registry.registerBeanDefinition("color",
            BeanDefinitionBuilder.genericBeanDefinition(Color.class, Color::new)
                    .addPropertyValue("name", "yelllow")
                    .getBeanDefinition());
  }
}
