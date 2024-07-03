package com.dhakad.design.single;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmployeeType {

	SENIOR_EMPLOYEE("Senior"), JUNIOR_EMPLOYEE("Junior");
	private String type;

}
