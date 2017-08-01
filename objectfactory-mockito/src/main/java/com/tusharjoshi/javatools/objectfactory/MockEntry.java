package com.tusharjoshi.javatools.objectfactory;

import org.mockito.stubbing.OngoingStubbing;

public class MockEntry<T> {
	private ObjectFactory<T> mockFactory = null;
	private OngoingStubbing<Object> stubbing = null;

	public MockEntry(ObjectFactory<T> mockFactory) {
		this.mockFactory = mockFactory;
	}

	public ObjectFactory<T> getMockFactory() {
		return mockFactory;
	}

	public OngoingStubbing<Object> getStubbing() {
		return stubbing;
	}

	public void setStubbing(OngoingStubbing<Object> stubbing) {
		this.stubbing = stubbing;
	}
}
