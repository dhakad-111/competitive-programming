package com.dhakad.design.abstrat.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ModelType {

	MI_BOLT("Mi-Bolt"), MI_FIRE("Mi-Fire"), MI_PLUS("Mi-Plus");
	private String type;

}
