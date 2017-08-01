package com.tusharjoshi.javatools.objectfactory;

public class ObjectFactoryException extends RuntimeException {

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

}
