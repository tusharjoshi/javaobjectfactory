package com.tusharjoshi.javatools.objectfactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ObjectCreatorTest {

  @Before
  public void setUp() {

  }

  @Test
  public void testCreate() {
    String name = ObjectCreator.create(String.class);
    Assert.assertNotNull(name);
  }

  @Test
  public void testCreateException() {
    try {
      ObjectCreator.create(NoDefConstructorClass.class);
      Assert.fail();
    } catch (ObjectFactoryException oe) {
      Assert.assertEquals(String.format(
          "Object could not be instantiated for class %s using default constructor, ensure default constructor is present.",
          NoDefConstructorClass.class.getName()), oe.getMessage());
    }
  }

  @Test
  public void testCreateOtherException() {
    try {
      ObjectCreator.create(InstantiationExceptionClass.class);
      Assert.fail();
    } catch (ObjectFactoryException oe) {
      Assert.assertEquals(String.format(
          "Object could not be instantiated for class %s.",
          InstantiationExceptionClass.class.getName()), oe.getMessage());
    }
  }

  @Test
  public void testCreateWithTypesAndArgsException() {
    try {
      ObjectCreator.create(InstantiationExceptionClass.class, new Class<?>[]{int.class, float.class}, new Object[]{2, 3.4});
      Assert.fail();
    } catch (ObjectFactoryException oe) {
      Assert.assertEquals(String.format(
          "Object could not be instantiated for class %s using constructor with types (int,float) and using values (2,3.4)",
          InstantiationExceptionClass.class.getName()), oe.getMessage());
    }
  }

  @Test
  public void testCreateWithTypesAndArgsExceptionString() {
    try {
      ObjectCreator.create(NoDefConstructorClass.class, new Class<?>[]{}, new Object[]{});
      Assert.fail();
    } catch (ObjectFactoryException oe) {
      Assert.assertEquals(String.format(
          "Object could not be instantiated for class %s using constructor with types () and using values ()",
          NoDefConstructorClass.class.getName()), oe.getMessage());
    }
  }

  @Test
  public void testCreateWithTypesAndArgsOtherException() {
    try {
      ObjectCreator.create(String.class, new Class<?>[]{int.class, float.class}, new Object[]{2, 3.4});
      Assert.fail();
    } catch (ObjectFactoryException oe) {
      Assert.assertEquals(String.format(
          "Object could not be instantiated for class %s using constructor with types (int,float) and using values (2,3.4)",
          String.class.getName()), oe.getMessage());
    }
  }

  public static class NoDefConstructorClass {
    private String name;

    public NoDefConstructorClass(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

  }

  public static class InstantiationExceptionClass {
    private String name;
    
    public InstantiationExceptionClass() {
      throw new RuntimeException();
    }

    public InstantiationExceptionClass(String name) {
      this.name = name;
      throw new RuntimeException();
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

  }

}
