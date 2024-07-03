package com.dhakad.design.single;

public class Client {

	public static void main(String[] args) {

		SalaryCalculator seniorEmployee = new SeniorEmployee();
		SalaryCalculator juniorEmployee = new JuniorEmployee();

		Employee employee = Employee.builder()
				.id(101).name("John Doe")
				.type(EmployeeType.JUNIOR_EMPLOYEE.getType())
				.salary(juniorEmployee).build();

		Employee employee2 = Employee.builder()
				.id(102).name("Jack")
				.type(EmployeeType.SENIOR_EMPLOYEE.getType())
				.salary(seniorEmployee).build();
		
		System.out.println("Junior Employee Salary Is: " + employee.calculateSalary());
		System.out.println("Senior Employee Salary Is : " + employee2.calculateSalary());
	}

}
