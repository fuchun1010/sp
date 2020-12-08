package com.tank.auto;

import com.tank.extra.ColorExtraBeanRegister;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author tank198435163.com
 */
@Configuration
@Import({ColorExtraBeanRegister.class})
public class TavernCfg {
}
