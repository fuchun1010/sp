package com.tank.resource;

import cn.hutool.core.util.StrUtil;
import lombok.NonNull;
import lombok.val;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * @author tank198435163.com
 */
public class TextResourceResolver implements ProtocolResolver, ResourceProtocol {

  @Override
  public Resource resolve(@NonNull final String location,
                          @NonNull final ResourceLoader resourceLoader) {
    if (!location.startsWith(this.resourceProtocolName())) {
      return null;
    }
    val realPath = location.substring(this.resourceProtocolName().length());
    val path = StrUtil.format("classpath:{}", realPath);
    return resourceLoader.getResource(path);
  }

  @Override
  public String resourceProtocolName() {
    return "text:";
  }
}
