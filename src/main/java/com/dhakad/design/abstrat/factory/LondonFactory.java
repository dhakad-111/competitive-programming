package com.dhakad.design.abstrat.factory;

public class LondonFactory implements MobileFactory {

	@Override
	public MiModel getInstance(ModelType type) {
		switch (type) {
		case MI_BOLT:
			return new MiBolt();

			case MI_PLUS:
			return new MiFire();
		default:
			throw new IllegalArgumentException("Invalid Mode Type!.");
		}
	}

}
