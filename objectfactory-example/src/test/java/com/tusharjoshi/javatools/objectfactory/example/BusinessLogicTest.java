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
@PrepareForTest({ObjectFactory.class})
public class BusinessLogicTest {
	
	private BusinessLogic target;
	private PersonService mockPersonService;
	private Person mockPerson;
	
	@Before
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
