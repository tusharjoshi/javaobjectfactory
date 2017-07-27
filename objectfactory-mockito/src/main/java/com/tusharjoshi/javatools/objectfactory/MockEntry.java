package com.tusharjoshi.javatools.objectfactory;

import org.mockito.stubbing.OngoingStubbing;

public class MockEntry {
	private ObjectFactory<?> mockFactory = null;
	private OngoingStubbing<Object> stubbing = null;

	public MockEntry(ObjectFactory<?> mockFactory) {
		this.mockFactory = mockFactory;
	}

	public ObjectFactory<?> getMockFactory() {
		return mockFactory;
	}

	public OngoingStubbing<Object> getStubbing() {
		return stubbing;
	}

	public void setStubbing(OngoingStubbing<Object> stubbing) {
		this.stubbing = stubbing;
	}
}
