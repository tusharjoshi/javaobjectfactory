package com.tusharjoshi.javatools.objectfactory;

public class ObjectFactory<T> {

	private Class<T> sourceClass;
	private Class<?>[] types;
	private Object[] args;

	private ObjectFactory(Class<T> sourceClass) {
		this.sourceClass = sourceClass;
	}

	public static <T> ObjectFactory<T> build(Class<T> sourceClass) {
		return new ObjectFactory<T>(sourceClass);
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
			throw new RuntimeException("No class defination");
		}
		
		if( null == types ) {
			return create(sourceClass);
		} else {
			return create(sourceClass, types, args);
		}
		
	}

	private static <T> T create(Class<T> sourceCLass) {
		T target;
		try {
			target = sourceCLass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return target;
	}

	private static <T> T create(Class<T> sourceCLass, Class<?>[] types, Object[] args) {
		T target;
		try {
			target = sourceCLass.getConstructor(types).newInstance(args);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return target;
	}

}
