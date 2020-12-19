package com.tank;

import cn.hutool.core.io.FileUtil;
import com.tank.resource.TextResourceResolver;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author tank198435163.com
 */
public class SpiApp {

  @SneakyThrows({IOException.class})
  public static void main(@NonNull final String[] args) {

    val textResource = new TextResourceResolver();
    val resourceLoader = new DefaultResourceLoader();
    resourceLoader.addProtocolResolver(textResource);
    val targetResource = resourceLoader.getResource(textResource.resourceProtocolName() + "word.txt");
    FileUtil.readLines(targetResource.getFile(), Charset.defaultCharset())
            .forEach(System.out::println);
  }
}
