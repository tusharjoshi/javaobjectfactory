package com.tusharjoshi.javatools.objectfactory;

public class ClassMapper {

  protected ClassMapper() {
    // utility class
  }

  public static String mapToClassName(Class<?> classObj) {
    return classObj.getName();
  }

  public static Class<?> mapToClass(Object object) {
    return object.getClass();
  }
}
