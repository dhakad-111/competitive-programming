package com.dhakad.design.open;

import java.math.BigDecimal;

public class Client {

	public static void main(String[] args) {

		CalculatorOperation addition = new Addition();
		CalculatorOperation multiplication = new Multiplication();

		Calculator calculator = Calculator.builder()
				.value1(BigDecimal.valueOf(10))
				.value2(BigDecimal.valueOf(20))
				.operation(addition).build();
		Calculator calculator2 = Calculator.builder()
				.value1(BigDecimal.valueOf(2))
				.value2(BigDecimal.valueOf(5))
				.operation(multiplication).build();
		
		System.out.println("Addition Result Is : " + calculator.perform());
		System.out.println("Multiplication Result Is : " + calculator2.perform());

	}

}
