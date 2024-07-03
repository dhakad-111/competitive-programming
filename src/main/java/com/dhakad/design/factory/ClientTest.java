package com.dhakad.design.factory;

import java.math.BigDecimal;

public class ClientTest {
	
	public static void main(String[] args) {
		
		MiModel instance1 = MiModelFactory.getInstance(ModelType.MI_BOLT, "2.95 HGZ", "120 GB", "4 GB", BigDecimal.valueOf(34000));
		
		MiModel instance2 = MiModelFactory.getInstance(ModelType.MI_FIRE, "2.95 HGZ", "120 GB", "8 GB", BigDecimal.valueOf(44000));
		System.out.println(instance1);
		System.out.println(instance2);
	}

}
