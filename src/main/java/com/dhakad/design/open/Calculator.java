package com.dhakad.design.open;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Calculator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal value1;
	private BigDecimal value2;
	private CalculatorOperation operation;

	public BigDecimal perform() {
		return operation.perform(this.value1, this.value2);
	}

}
