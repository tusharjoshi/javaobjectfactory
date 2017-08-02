package com.tusharjoshi.javatools.objectfactory.example;

import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tusharjoshi.javatools.objectfactory.ObjectFactory;
import com.tusharjoshi.javatools.objectfactory.ObjectFactoryMocker;

@PrepareForTest({ObjectFactory.class})
public class BusinessLogicTest extends PowerMockTestCase {
	
	private BusinessLogic target;
	private AnimalService mockAnimalService;
	private Animal mockAnimal;
	
	@BeforeMethod
	public void setUp() {
		mockAnimalService = Mockito.mock(AnimalService.class);
		mockAnimal = Mockito.mock(Animal.class);
		
		Mockito.when(mockAnimalService.fetchAnimal()).thenReturn(mockAnimal);
		ObjectFactoryMocker.mock()
			.when(AnimalService.class, mockAnimalService);
		
		target = new BusinessLogic();
	}

	@Test
	public void testSomeLogic() {
		Animal animal = target.someLogic();
		
		Assert.assertEquals(animal, mockAnimal);
		
	}
}
