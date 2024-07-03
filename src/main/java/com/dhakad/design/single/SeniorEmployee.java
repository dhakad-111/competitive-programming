package com.dhakad.design.single;

import java.math.BigDecimal;

public class SeniorEmployee implements SalaryCalculator {

	private static final BigDecimal HOURLY_RATE = BigDecimal.valueOf(500);
	private static final BigDecimal HOURS_WORKED = BigDecimal.valueOf(40);

	@Override
	public BigDecimal calculateSalary(String position) {
		if (EmployeeType.SENIOR_EMPLOYEE.getType().equalsIgnoreCase(position)) {
			return HOURLY_RATE.multiply(HOURS_WORKED);
		} else {
			throw new IllegalArgumentException("Invalid Employee Type");
		}
	}

}
