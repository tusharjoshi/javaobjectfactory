package com.tusharjoshi.javatools.objectfactory;

public class ObjectFactory<T> {

	private Class<T> sourceClass;
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
		types = new Class<?>[args.length];
		int index = 0;
		for( Object obj : args) {
			types[index] = obj.getClass();
			index++;
		}
	}

	public T create() {
		
		if( null == sourceClass) {
			throw new ObjectFactoryException("No class defination");
		}
		
		if( null == types ) {
			return ObjectCreator.create(sourceClass);
		} else {
			return ObjectCreator.create(sourceClass, types, args);
		}
		
	}

}
