package com.dhakad.design.singleton;

public class MyThread implements Runnable {

	@Override
	public void run() {
		Employee instance = Employee.createInstance();
		System.out.println(instance.hashCode());
	}

}
