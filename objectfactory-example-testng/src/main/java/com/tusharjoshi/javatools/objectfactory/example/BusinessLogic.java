package com.tusharjoshi.javatools.objectfactory.example;

import com.tusharjoshi.javatools.objectfactory.ObjectFactory;

public class BusinessLogic {
	
	private AnimalService animalService;
	
	public BusinessLogic() {
		animalService = ObjectFactory.build(AnimalService.class)
				.create();
	}
	
	public Animal someLogic() {
		return animalService.fetchAnimal();
	}

}
