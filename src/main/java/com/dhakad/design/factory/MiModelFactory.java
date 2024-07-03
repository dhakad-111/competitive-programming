package com.dhakad.design.factory;

import java.math.BigDecimal;

public class MiModelFactory {

	public static MiModel getInstance(ModelType modelType, String cup, String hdd, String ram, BigDecimal price) {
		switch (modelType) {
		case MI_BOLT:
			return new MiBolt(cup, hdd, ram, price);

		case MI_FIRE:
			return new MiFire(cup, hdd, ram, price);
		default:
			throw new IllegalArgumentException("Unexpected value: " + modelType);
		}
	}

}
