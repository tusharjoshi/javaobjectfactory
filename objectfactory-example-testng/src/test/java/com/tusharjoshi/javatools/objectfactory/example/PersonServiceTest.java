package com.tusharjoshi.javatools.objectfactory.example;

import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tusharjoshi.javatools.objectfactory.ObjectFactory;
import com.tusharjoshi.javatools.objectfactory.ObjectFactoryMocker;

@PrepareForTest({ ObjectFactory.class })
public class PersonServiceTest extends PowerMockTestCase {

	private PersonService target;
	private Person mockPerson;

	@BeforeMethod
	public void setUp() {
		mockPerson = Mockito.mock(Person.class);

		ObjectFactoryMocker.mock().when(Person.class, mockPerson);

		target = new PersonService();
	}

	@Test
	public void testEnrollPerson() {

		Person person = target.enrollPerson();
		
		Assert.assertEquals(mockPerson, person);
	}
}
