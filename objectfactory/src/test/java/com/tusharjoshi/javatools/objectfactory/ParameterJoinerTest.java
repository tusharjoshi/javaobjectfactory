package com.tusharjoshi.javatools.objectfactory;

import org.junit.Assert;
import org.junit.Test;

public class ParameterJoinerTest {

  @Test
  public void testParameterJoiner() {
    ParameterJoiner object = new ParameterJoiner(){};
    Assert.assertNotNull(object);
  }
  
  @Test 
  public void testJoin() {
    String value = ParameterJoiner.join(new String[]{"2","3","4"}, Object::toString);
    Assert.assertEquals("(2, 3, 4)", value);
  }

}
