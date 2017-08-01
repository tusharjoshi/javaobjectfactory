package com.tusharjoshi.javatools.objectfactory.example;

import com.tusharjoshi.javatools.objectfactory.ObjectFactory;

public class PersonService {

	public Person enrollPerson() {
		return ObjectFactory.build(Person.class)
				.withTypes(String.class, int.class)
				.withArgs("John Doe", 29)
				.create();
	}

}
