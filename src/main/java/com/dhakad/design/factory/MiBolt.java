package com.dhakad.design.factory;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MiBolt implements MiModel{
	
	private String cup;
	
	private String hdd;
	
	private String ram;
	
	private BigDecimal price;

	@Override
	public String cup() {
		return this.cup;
	}

	@Override
	public String hdd() {
		return this.hdd;
	}

	@Override
	public String ram() {
		return this.ram;
	}

	@Override
	public BigDecimal price() {
		return this.price;
	}
	


}
