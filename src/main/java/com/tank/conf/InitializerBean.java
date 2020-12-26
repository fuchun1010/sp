package com.tank.conf;

import com.tank.resource.YmlPropsSourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author tank198435163.com
 */

@Configuration
@PropertySource(value = "classpath:init.yml", factory = YmlPropsSourceFactory.class)
public class InitializerBean {

}
