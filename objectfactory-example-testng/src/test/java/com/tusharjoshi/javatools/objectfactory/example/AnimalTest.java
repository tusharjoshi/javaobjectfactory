package com.tusharjoshi.javatools.objectfactory.example;

import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnimalTest extends PowerMockTestCase {

  private Animal target;
  
  @BeforeMethod
  public void setUp() {
    target = new Animal();
  }
  
  @Test
  public void testAnimal() {
    Assert.assertNotNull(target);
  }
  
  @Test
  public void testSetSpecies() {
    target.setSpecies("Mammal");
    Assert.assertEquals("Mammal", target.getSpecies());
  }
  
  @Test
  public void testSetLegs() {
    target.setLegs(4);
    Assert.assertEquals(4, target.getLegs());
  }

}
