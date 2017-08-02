package com.tusharjoshi.javatools.objectfactory.example;

import com.tusharjoshi.javatools.objectfactory.ObjectFactory;

public class AnimalService {

  public Animal fetchAnimal() {
      return ObjectFactory.build(Animal.class)
              .withTypes(String.class, int.class)
              .withArgs("Mammal", 4)
              .create();
  }

}
