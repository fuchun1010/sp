package com.tank;

import com.google.common.collect.Sets;
import io.vavr.control.Option;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

/**
 * @author tank198435163.com
 */
public class CollectionTest {


  @Test
  public void testLinkHashSet() {
    val sets = Sets.<Integer>newLinkedHashSet();
    sets.add(1);
    sets.add(7);
    sets.add(5);
    Assert.assertEquals(sets.size(), 3);
    val resultOpt = this.obtainByIndex(sets, 2);
    Assert.assertTrue(resultOpt.isDefined());
    val result = resultOpt.getOrElse(0);
    Assert.assertEquals(result.intValue(), 7);
  }

  private <T> Option<T> obtainByIndex(Collection<T> collection, Integer index) {
    val iterator = collection.iterator();
    int counter = 0;
    while (iterator.hasNext()) {
      val result = iterator.next();
      counter++;
      if (index.compareTo(counter) == 0) {
        return Option.of(result);
      }
    }

    return Option.none();
  }
}
