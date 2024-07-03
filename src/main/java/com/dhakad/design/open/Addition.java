package com.dhakad.design.open;

import java.math.BigDecimal;

public class Addition implements CalculatorOperation {

	@Override
	public BigDecimal perform(BigDecimal value1, BigDecimal value2) {
		return value1.add(value2);
	}

}
