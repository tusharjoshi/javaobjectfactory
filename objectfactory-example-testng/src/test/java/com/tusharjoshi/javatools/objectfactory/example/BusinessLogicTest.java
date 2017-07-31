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
	private PersonService mockPersonService;
	private Person mockPerson;
	
	@BeforeMethod
	public void setUp() {
		mockPersonService = Mockito.mock(PersonService.class);
		mockPerson = Mockito.mock(Person.class);
		
		Mockito.when(mockPersonService.enrollPerson()).thenReturn(mockPerson);
		ObjectFactoryMocker.mock()
			.when(PersonService.class, mockPersonService);
		
		target = new BusinessLogic();
	}

	@Test
	public void testSomeLogic() {
		Person person = target.someLogic();
		
		Assert.assertEquals(person, mockPerson);
		
	}
}
