package com.tusharjoshi.javatools.objectfactory;

import org.junit.Assert;
import org.junit.Test;

public class ClassMapperTest {

  @Test
  public void testClassMapper() {
    Assert.assertNotNull(new ClassMapper() {});
  }
  
  @Test
  public void testMapToClassName() {
    String actual = ClassMapper.mapToClassName(String.class);
    Assert.assertEquals("java.lang.String", actual);
  }
  
  @Test
  public void testMapToClass() {
    Class<?> actual = ClassMapper.mapToClass("Hello");
    Assert.assertEquals(actual, "Hello".getClass());
  }
}
