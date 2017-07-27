package com.tusharjoshi.javatools.objectfactory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ObjectFactory.class)
public class ObjectFactoryTest {

	@Test (expected=RuntimeException.class)
	public void testBuildNull() {
		ObjectFactory.build(null).create();
	}

	@Test
	public void testBuildSting() {
		String strObj = ObjectFactory.build(String.class).create();
		Assert.assertNotNull(strObj);
	}

	@Test
	public void testBuildWithTypesAndArgs() {
		Person person = ObjectFactory.build(Person.class)
				.withTypes(String.class, int.class)
				.withArgs("Sam Tarly", 32)
				.create();

		Assert.assertNotNull(person);
		Assert.assertEquals(person.getName(), "Sam Tarly");
		Assert.assertEquals(person.getAge(), 32);
	}

	@Test
	public void testBuildWithArgsOnly() {
		Person person = ObjectFactory.build(Person.class)
				.withArgs("Sam Tarly")
				.create();

		Assert.assertNotNull(person);
		Assert.assertEquals(person.getName(), "Sam Tarly");
		Assert.assertEquals(person.getAge(), 25);
	}

	@Test
	public void testPersonService() {
		Person mockPerson1 = Mockito.mock(Person.class);
		Person mockPerson2 = Mockito.mock(Person.class);
		Vehicle mockVehicle = Mockito.mock(Vehicle.class);
		
		ObjectFactoryMocker.mock()
			.when(Person.class, mockPerson1, mockPerson2)
			.when(Vehicle.class, mockVehicle);

		Person person1 = PersonService.generatePerson();

		Person person2 = PersonService.generatePerson();

		Vehicle vehicle1 = VehicleService.makeVehicle();

		Assert.assertEquals(person1, mockPerson1);

		Assert.assertEquals(person2, mockPerson2);

		Assert.assertEquals(vehicle1, mockVehicle);
	}

	@Test
	public void testPersonService2() {
		Person mockPerson1 = Mockito.mock(Person.class);
		Person mockPerson2 = Mockito.mock(Person.class);
		Person mockPerson3 = Mockito.mock(Person.class);
		Person mockPerson4 = Mockito.mock(Person.class);
		Vehicle mockVehicle1 = Mockito.mock(Vehicle.class);
		Vehicle mockVehicle2 = Mockito.mock(Vehicle.class);
		
		ObjectFactoryMocker.mock()
			.when(Person.class, mockPerson1)
			.when(Person.class, mockPerson2)
			.when(Vehicle.class, mockVehicle1)
			.when(Person.class, mockPerson3, mockPerson4)
			.when(Vehicle.class, mockVehicle2);

		Person person1 = PersonService.generatePerson();

		Person person2 = PersonService.generatePerson();

		Person person3 = PersonService.generatePerson();

		Person person4 = PersonService.generatePerson();

		Vehicle vehicle1 = VehicleService.makeVehicle();

		Vehicle vehicle2 = VehicleService.makeVehicle();

		Assert.assertEquals(person1, mockPerson1);

		Assert.assertEquals(person2, mockPerson2);

		Assert.assertEquals(person3, mockPerson3);

		Assert.assertEquals(person4, mockPerson4);

		Assert.assertEquals(vehicle1, mockVehicle1);

		Assert.assertEquals(vehicle2, mockVehicle2);
	}

}
