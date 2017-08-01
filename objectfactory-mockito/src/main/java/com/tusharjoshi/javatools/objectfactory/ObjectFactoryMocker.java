package com.tusharjoshi.javatools.objectfactory;

import java.util.HashMap;
import java.util.Map;

import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

@PrepareForTest(ObjectFactory.class)
public class ObjectFactoryMocker {

	private static final int INDEX_FIRST = 0;
	private static final int INDEX_SECOND = 1;
	private static Map<Class<?>, MockEntry<?>> mockMap = new HashMap<>();

	private ObjectFactoryMocker() {
		PowerMockito.mockStatic(ObjectFactory.class);
	}

	public static ObjectFactoryMocker mock() {
		return new ObjectFactoryMocker();
	}

	public ObjectFactoryMocker when(Class<?> sourceClass, Object... args) {
		MockEntry<?> mockEntry = getMockEntry(sourceClass);
		stubReturnTypes(mockEntry, args);
		return this;
	}

	private void stubReturnTypes(MockEntry<?> mockEntry, Object... args) {
		OngoingStubbing<Object> ongoingStubbing = mockEntry.getStubbing();
		if (null == ongoingStubbing) {
			ongoingStubbing = createOngoingStupWithFirstArgValue(mockEntry, args[0]);
			stubReturnValuesFromGivenIndexOnwards(ongoingStubbing, INDEX_SECOND, args);
		} else {
			stubReturnValuesFromGivenIndexOnwards(ongoingStubbing, INDEX_FIRST, args);
		}		
	}

	public OngoingStubbing<Object> createOngoingStupWithFirstArgValue(MockEntry<?> mockEntry, Object arg) {
		@SuppressWarnings("rawtypes")
		ObjectFactory mockFactory = mockEntry.getMockFactory();
		OngoingStubbing<Object> ongoingStubbing = Mockito.when((mockFactory).create()).thenReturn(arg);
		mockEntry.setStubbing(ongoingStubbing);
		return ongoingStubbing;
	}

	private static void stubReturnValuesFromGivenIndexOnwards(
			OngoingStubbing<Object> ongoingStubbing, 
			int fromIndex, Object[] args) {
		if (args.length > fromIndex) {
			for (int index = fromIndex; index < args.length; index++) {
				ongoingStubbing.thenReturn(args[index]);
			}
		}
	}

	private <T> MockEntry<?> getMockEntry(Class<T> sourceClass) {
		MockEntry<?> mockEntry = mockMap.get(sourceClass);
		if (null == mockEntry) {
			mockEntry = createMockEntry(sourceClass);
		}
		return mockEntry;
	}

	@SuppressWarnings({ "rawtypes" })
	private <T> MockEntry createMockEntry(Class<T> sourceClass) {
		@SuppressWarnings("unchecked")
        ObjectFactory<T> mockFactory = (ObjectFactory<T>) Mockito.mock(ObjectFactory.class);
		MockEntry<?> mockEntry = new MockEntry<T>(mockFactory);
		mockMap.put(sourceClass, mockEntry);
		stubFactoryMethods(sourceClass, mockFactory);
		return mockEntry;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private <T> void stubFactoryMethods(Class<T> sourceClass, ObjectFactory mockFactory) {
		Mockito.when(ObjectFactory.build(sourceClass)).thenReturn(mockFactory);
		Mockito.when(mockFactory.withTypes((Class<?>[]) Mockito.anyVararg())).thenReturn(mockFactory);
		Mockito.when(mockFactory.withArgs(Mockito.anyVararg())).thenReturn(mockFactory);
	}
}
