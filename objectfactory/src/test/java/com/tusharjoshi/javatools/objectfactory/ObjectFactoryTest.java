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

  @Test(expected = ObjectFactoryException.class)
  public void testBuildNull() {
    ObjectFactory.build(null).create();
  }

  @Test(expected = ObjectFactoryException.class)
  public void testBuildCreateException() {
    ObjectFactory.build(ObjectWithException.class).create();
  }

  @Test(expected = ObjectFactoryException.class)
  public void testBuildWithArgsCreateException() {
    ObjectFactory.build(ObjectWithException.class)
      .withArgs("Hello")
      .create();
  }

  @Test
  public void testBuild() {
    Assert.assertNotNull(target);
  }

  @Test
  public void testCreate() {
    String value = target.create();
    Assert.assertNotNull(value);
    Assert.assertEquals("", value);
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
    @SuppressWarnings("unused")
    private String param = null;

    public ObjectWithException() {
      throw new ObjectFactoryException("");
    }

    @SuppressWarnings("unused")
    public ObjectWithException(String param) {
      this.param = param;
      try {
        int x = 0;
        int y = 23/x;
      } catch( Exception e) {
        throw new ObjectFactoryException("");
      }
    }
  }

}
