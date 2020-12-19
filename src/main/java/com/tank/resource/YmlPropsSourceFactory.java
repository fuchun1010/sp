package com.tank.resource;

import cn.hutool.core.util.StrUtil;
import lombok.NonNull;
import lombok.val;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;

/**
 * @author tank198435163.com
 */
public class YmlPropsSourceFactory implements PropertySourceFactory {

  @Override
  public PropertySource<?> createPropertySource(String name, @NonNull final EncodedResource resource) throws IOException {
    val factory = new YamlPropertiesFactoryBean();
    factory.setSingleton(true);
    factory.setResources(resource.getResource());
    val props = factory.getObject();
    return new PropertiesPropertySource(StrUtil.isEmptyIfStr(name) ? resource.getResource().getFilename() : name, props);
  }
}
