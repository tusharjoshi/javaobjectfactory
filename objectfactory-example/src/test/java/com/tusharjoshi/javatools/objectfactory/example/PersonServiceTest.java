package com.tusharjoshi.javatools.objectfactory.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.tusharjoshi.javatools.objectfactory.ObjectFactory;
import com.tusharjoshi.javatools.objectfactory.ObjectFactoryMocker;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ ObjectFactory.class })
public class PersonServiceTest {

	private PersonService target;
	private Person mockPerson;

	@Before
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
