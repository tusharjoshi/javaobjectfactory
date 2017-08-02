package com.tusharjoshi.javatools.objectfactory.example;

import com.tusharjoshi.javatools.objectfactory.ObjectFactory;

public class BusinessLogic {
	
	private AnimalService personService;
	
	public BusinessLogic() {
		personService = ObjectFactory.build(AnimalService.class)
				.create();
	}
	
	public Animal someLogic() {
		return personService.fetchAnimal();
	}

}
