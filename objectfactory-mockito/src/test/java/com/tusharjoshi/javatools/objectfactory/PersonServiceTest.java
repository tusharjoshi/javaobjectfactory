package com.tusharjoshi.javatools.objectfactory;

import org.junit.Assert;
import org.junit.Test;

public class PersonServiceTest {

	
	@Test
	public void testPersonServiceReal() {

		Person person = AnimalService.generatePerson();
	
		Assert.assertNotNull(person);
		Assert.assertEquals(person.getName(), "John Snow");
		Assert.assertEquals(person.getAge(), 30);
	}
}
