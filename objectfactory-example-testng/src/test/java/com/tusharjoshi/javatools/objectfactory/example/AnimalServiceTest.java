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
public class AnimalServiceTest extends PowerMockTestCase {

	private AnimalService target;
	private Animal mockAnimal;

	@BeforeMethod
	public void setUp() {
		mockAnimal = Mockito.mock(Animal.class);

		ObjectFactoryMocker.mock().when(Animal.class, mockAnimal);

		target = new AnimalService();
	}

	@Test
	public void testFetchAnimal() {

		Animal animal = target.fetchAnimal();
		
		Assert.assertEquals(mockAnimal, animal);
	}
}
