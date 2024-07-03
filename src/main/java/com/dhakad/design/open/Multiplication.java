package com.dhakad.design.open;

import java.math.BigDecimal;

public class Multiplication implements CalculatorOperation {

	@Override
	public BigDecimal perform(BigDecimal value1, BigDecimal value2) {
		return value1.multiply(value2);
	}

}
