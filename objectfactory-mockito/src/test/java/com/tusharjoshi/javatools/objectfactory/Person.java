package com.tusharjoshi.javatools.objectfactory;

public class Person {

	private String name;
	private int age;

	public Person() {
		this("John Doe", 25);
	}

	public Person(String name) {
		this(name, 25);
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
