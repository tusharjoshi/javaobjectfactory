package com.tusharjoshi.javatools.objectfactory;

public class ObjectFactoryException extends RuntimeException {

  private static final String NO_DEF_CONST_MESSAGE = "Object could not be instantiated for class %s using default constructor, ensure default constructor is present.";

  private static final String GENERIC_MESSAGE = "Object could not be instantiated for class %s.";

  /**
  * 
  */
  private static final long serialVersionUID = 1L;

  public ObjectFactoryException(String message) {
    super(message);
  }

  public ObjectFactoryException(Throwable throwable) {
    super(throwable);
  }

  public ObjectFactoryException(String message, Throwable throwable) {
    super(message, throwable);
  }

  public static ObjectFactoryException defaultConstructorException(Class<?> sourceClass, Throwable throwable) {
    return new ObjectFactoryException(String.format(NO_DEF_CONST_MESSAGE, sourceClass.getName()), throwable);
  }

  public static ObjectFactoryException genericException(Class<?> sourceClass, Throwable throwable) {
    return new ObjectFactoryException(String.format(GENERIC_MESSAGE, sourceClass.getName()), throwable);
  }

  public static ObjectFactoryException typesAndArgsException(Class<?> sourceClass, Class<?>[] types, Object[] args,
      Throwable throwable) {
    return new ObjectFactoryException(generateMessage(sourceClass.getName(), types, args), throwable);
  }

  private static String generateMessage(String name, Class<?>[] types, Object[] args) {
    StringBuilder buffer = new StringBuilder();
    buffer.append("Object could not be instantiated for class ");
    buffer.append(name);
    buffer.append(" using constructor with types ");
    buffer.append(generateTypesString(types));
    buffer.append(generateArgsString(args));
    return buffer.toString();
  }
  
  private static String generateTypesString(Class<?>[] types) {
    StringBuilder buffer = new StringBuilder();
    buffer.append("(");
    if( types.length > 1 ) {
      for( Class<?> typeClass : types ) {
        buffer.append(typeClass.getName());
        buffer.append(",");
      }
      buffer.replace(buffer.length()-1, buffer.length(), ")");
    } else {
      buffer.append(")");
    }
    return buffer.toString();
  }
  
  private static String generateArgsString(Object[] args) {
    StringBuilder buffer = new StringBuilder();
    buffer.append(" and using values ");
    buffer.append("(");
    if( args.length > 1 ) {
      for( Object arg : args ) {
        buffer.append(arg.toString());
        buffer.append(",");
      }
      buffer.replace(buffer.length()-1, buffer.length(), ")");
    } else {
      buffer.append(")");
    }
    return buffer.toString();
  }

}
