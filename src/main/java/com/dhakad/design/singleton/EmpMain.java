package com.dhakad.design.singleton;


public class EmpMain {

	public static void main(String[] args) {

		Employee instance = Employee.createInstance();
		Employee instance2 = Employee.createInstance();
		System.out.println(instance.hashCode());
		System.out.println(instance2.hashCode());

		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Employee instance3 = Employee.createInstance();
				System.out.println(instance3.hashCode());
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Employee instance4 = Employee.createInstance();
				System.out.println(instance4.hashCode());
			}
		});
		
		thread.start();
		thread2.start();
		
		
	}

}
