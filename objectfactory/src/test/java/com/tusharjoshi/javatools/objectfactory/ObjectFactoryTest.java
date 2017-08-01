package com.tusharjoshi.javatools.objectfactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ObjectFactoryTest {
  
  private ObjectFactory<String> target;
  
  @Before
  public void setUp() {
    target = ObjectFactory.build(String.class);
  }
  
  @Test (expected=ObjectFactoryException.class)
  public void testBuildNull() {
    ObjectFactory.build(null).create();
  }
  
  @Test (expected=ObjectFactoryException.class)
  public void testBuildCreateException() {
    ObjectFactory.build(ObjectWithException.class).create();
  }

  @Test
  public void testBuild() {
    Assert.assertNotNull(target);
  }

  @Test
  public void testWithArgs() {
    String value = target.withArgs("Hello").create();
    Assert.assertNotNull(value);
    Assert.assertEquals("Hello", value);
  }

  @Test
  public void testWithTypesAndArgs() {
    String value = target.withTypes(String.class).withArgs("Hello").create();
    Assert.assertNotNull(value);
    Assert.assertEquals("Hello", value);
  }
  
  public static class ObjectWithException {
    public ObjectWithException() {
      throw new ObjectFactoryException("");
    }
  }

}
