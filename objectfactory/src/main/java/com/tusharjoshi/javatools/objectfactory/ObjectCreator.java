package com.tusharjoshi.javatools.objectfactory;

public class ObjectCreator {
  
  protected ObjectCreator() {
    // utility class
  }

  public static <T> T create(Class<T> sourceClass) {
    try {
      return sourceClass.newInstance();
    } catch (InstantiationException e) {
      throw ObjectFactoryException.defaultConstructorException(sourceClass, e);
    } catch (Exception e) {
      throw ObjectFactoryException.genericException(sourceClass, e);
    }
  }

  public static <T> T create(Class<T> sourceClass, Class<?>[] types, Object[] args) {
    try {
      return sourceClass.getConstructor(types).newInstance(args);
    } catch (NoSuchMethodException e) {
      throw ObjectFactoryException.typesAndArgsException(sourceClass, types, args, e);
    } catch (Exception e) {
      throw ObjectFactoryException.genericException(sourceClass, e);
    }
  }
}
