package com.tusharjoshi.javatools.objectfactory;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ObjectFactory<T> {

	private final Class<T> sourceClass;
	private Class<?>[] types;
	private Object[] args;

	private ObjectFactory(Class<T> sourceClass) {
		this.sourceClass = sourceClass;
	}

	public static <T> ObjectFactory<T> build(Class<T> sourceClass) {
		return new ObjectFactory<>(sourceClass);
	}

	public ObjectFactory<T> withTypes(Class<?>... types) {
		this.types = types;
		return this;
	}

	public ObjectFactory<T> withArgs(Object... args) {
		if( null == types) {
			createTypesFromArgValues(args);
		}
		this.args = args;
		return this;
	}

	private void createTypesFromArgValues(Object... args) {		
		types = Arrays.stream(args)
		    .map(ClassMapper::mapToClass)
		    .collect(Collectors.toList())
		    .toArray(new Class[] {});
	}

	public T create() {
		
		if( null == sourceClass) {
			throw ObjectFactoryException.nullSourceClassException();
		}
		
		if( null == types ) {
			return ObjectCreator.create(sourceClass);
		} else {
			return ObjectCreator.create(sourceClass, types, args);
		}
		
	}

}
