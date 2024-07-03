package com.dhakad.design.singleton;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Employee {

	private static Employee employee;

	private Employee() {

	}

	public static Employee createInstance() {
		if (employee == null) {
			synchronized (Employee.class) {
				employee = new Employee();
			}
		}
		return employee;
	}

}
