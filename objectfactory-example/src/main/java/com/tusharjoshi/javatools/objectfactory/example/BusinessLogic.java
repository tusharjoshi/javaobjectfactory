package com.tusharjoshi.javatools.objectfactory.example;

import com.tusharjoshi.javatools.objectfactory.ObjectFactory;

public class BusinessLogic {
	
	private PersonService personService;
	
	public BusinessLogic() {
		personService = ObjectFactory.build(PersonService.class)
				.create();
	}
	
	public Person someLogic() {
		return personService.enrollPerson();
	}

}
