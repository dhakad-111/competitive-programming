package com.dhakad.design.abstrat.factory;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MiPlus implements MiModel {

	private String cpu;

	private String hdd;

	private String ram;

	private BigDecimal price;

	@Override
	public String cpu() {
		return this.cpu;
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
