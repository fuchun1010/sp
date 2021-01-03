package com.tank;

import cn.hutool.core.util.StrUtil;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author tank198435163.com
 */
public class HiveTableTest {

  @Test
  public void testGenerateTable() {
    val sql = StrUtil.format("create table {} (uid varchar) stored as orc TBLPROPERTIES(\"orc.compress\"=\"SNAPPY\")", "tag_01");
    Assert.assertNotNull(sql);
    System.out.println(sql);
  }

  @Test
  public void testMaxLongValue() {
    val result = Long.MAX_VALUE;
    System.out.println(result);
    System.out.println(Integer.MAX_VALUE);
  }

}
