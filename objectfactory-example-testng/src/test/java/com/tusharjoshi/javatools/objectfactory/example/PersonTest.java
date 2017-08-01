package com.tusharjoshi.javatools.objectfactory.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

  private Person target;
  
  @Before
  public void setUp() {
    target = new Person();
  }
  
  @Test
  public void testPerson() {
    Assert.assertNotNull(target);
  }
  
  @Test
  public void testSetName() {
    target.setName("John Doe");
    Assert.assertEquals("John Doe", target.getName());
  }
  
  @Test
  public void testSetAge() {
    target.setAge(29);
    Assert.assertEquals(29, target.getAge());
  }

}
