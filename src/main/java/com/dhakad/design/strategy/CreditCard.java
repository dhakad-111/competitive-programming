package com.dhakad.design.strategy;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class CreditCard implements Payment {
	
	private String cardHolderName;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;

	@Override
	public void pay(BigDecimal amount) {
		System.out.println(amount + "paid using CreditCard");
	}
}
