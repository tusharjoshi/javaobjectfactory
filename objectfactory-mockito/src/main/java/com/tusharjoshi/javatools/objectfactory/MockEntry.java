package com.tusharjoshi.javatools.objectfactory;

import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

public class MockEntry<T> {

  private static final int INDEX_FIRST = 0;
  private static final int INDEX_SECOND = 1;
  private ObjectFactory<T> mockFactory = null;
  private OngoingStubbing<T> stubbing = null;

  @SuppressWarnings("unchecked")
  public MockEntry(Class<T> sourceClass) {
    this.mockFactory = Mockito.mock(ObjectFactory.class);
    stubFactoryMethods(sourceClass);
  }

  public ObjectFactory<T> getMockFactory() {
    return mockFactory;
  }

  public OngoingStubbing<T> getStubbing() {
    return stubbing;
  }

  public void setStubbing(OngoingStubbing<T> stubbing) {
    this.stubbing = stubbing;
  }

  public void stubReturnTypes(T[] args) {
    int index = INDEX_FIRST;
    if (null == stubbing) {
      createOngoingStubWithFirstArgValue(args[0]);
      index = INDEX_SECOND;
    }
    stubReturnValuesFromGivenIndexOnwards(index, args);
  }

  private void stubFactoryMethods(Class<T> sourceClass) {
    Mockito.when(ObjectFactory.build(sourceClass)).thenReturn((ObjectFactory<T>)mockFactory);
    Mockito.when(mockFactory.withTypes((Class<?>[]) Mockito.anyVararg())).thenReturn(mockFactory);
    Mockito.when(mockFactory.withArgs(Mockito.anyVararg())).thenReturn(mockFactory);
  }

  private void createOngoingStubWithFirstArgValue(T arg) {
    stubbing = Mockito.when((mockFactory).create()).thenReturn(arg);
  }

  private void stubReturnValuesFromGivenIndexOnwards(int fromIndex, T[] args) {
    for (int index = fromIndex; index < args.length; index++) {
      stubbing.thenReturn(args[index]);
    }
  }
}
