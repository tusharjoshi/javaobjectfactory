package com.tusharjoshi.javatools.objectfactory;

public class AnimalService {
	
	public static Person generatePerson() {
		return ObjectFactory.build(Person.class)
				.withTypes(String.class, int.class)
				.withArgs("John Snow", 30)
				.create();
						
	}

}
