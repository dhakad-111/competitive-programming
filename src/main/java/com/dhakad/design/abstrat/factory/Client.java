package com.dhakad.design.abstrat.factory;

public class Client {

	public static void main(String[] args) {

		LondonFactory londonFactory = new LondonFactory();
		MiModel instance1 = londonFactory.getInstance(ModelType.MI_PLUS);

		NewYorkFactory newYorkFactory = new NewYorkFactory();
		MiModel instance2 = newYorkFactory.getInstance(ModelType.MI_BOLT);
		System.out.println(instance1);
		System.out.println(instance2);
	}

}
