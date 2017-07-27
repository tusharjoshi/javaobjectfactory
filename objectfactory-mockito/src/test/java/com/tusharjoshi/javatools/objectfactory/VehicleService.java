package com.tusharjoshi.javatools.objectfactory;

public class VehicleService {

	public static Vehicle makeVehicle() {
		return ObjectFactory.build(Vehicle.class).create();
	}
}
