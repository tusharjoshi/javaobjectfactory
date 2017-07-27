package com.tusharjoshi.javatools.objectfactory;

public class PersonService {
	
	public static Person generatePerson() {
		return ObjectFactory.build(Person.class)
				.withTypes(String.class, int.class)
				.withArgs("John Snow", 30)
				.create();
						
	}

}
