package com.dhakad.design.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ModelType {
	MI_BOLT("Mi Bolt"),
	MI_FIRE("Mi Fire");
	private String mode;

}
