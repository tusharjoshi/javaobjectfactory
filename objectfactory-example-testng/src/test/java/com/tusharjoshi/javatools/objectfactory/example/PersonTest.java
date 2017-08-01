package com.tusharjoshi.javatools.objectfactory.example;

import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonTest extends PowerMockTestCase {

  private Person target;
  
  @BeforeMethod
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
