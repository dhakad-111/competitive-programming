package com.dhakad.design.liskov;

public class ElectricCar implements Car{

	@Override
	public void turnOnEngine()  {
		throw new AssertionError("I don't have a Engine!");
	}

	@Override
	public void accelerate() {
		// TODO Auto-generated method stub
		
	}

}
