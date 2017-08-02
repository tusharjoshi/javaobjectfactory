package com.tusharjoshi.javatools.objectfactory;

import java.util.HashMap;
import java.util.Map;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

@PrepareForTest(ObjectFactory.class)
public class ObjectFactoryMocker {

  private Map<Class<?>, MockEntry<?>> mockMap = new HashMap<>();

  private ObjectFactoryMocker() {
    PowerMockito.mockStatic(ObjectFactory.class);
  }

  public static ObjectFactoryMocker mock() {
    return new ObjectFactoryMocker();
  }

  public <T> ObjectFactoryMocker when(Class<T> sourceClass, @SuppressWarnings("unchecked") T... args) {
    getMockEntry(sourceClass).stubReturnTypes(args);
    return this;
  }

  @SuppressWarnings("unchecked")
  private <T> MockEntry<T> getMockEntry(Class<T> sourceClass) {
    MockEntry<T> mockEntry = (MockEntry<T>) mockMap.get(sourceClass);
    if (null == mockEntry) {
      mockEntry = createMockEntry(mockMap, sourceClass);
    }
    return mockEntry;
  }

  private static <T> MockEntry<T> createMockEntry(Map<Class<?>, MockEntry<?>> mockMap, Class<T> sourceClass) {
    MockEntry<T> mockEntry = new MockEntry<>(sourceClass);
    mockMap.put(sourceClass, mockEntry);
    return mockEntry;
  }
}
