package com.myproject.web;

import java.util.Random;

public class ClassInitialization {
	public static Random random = new Random(47);

	public static void main(String[] args) throws ClassNotFoundException {
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staticFinal2);
		System.out.println(Initable2.staticFinal);
		Class initable3 = Class.forName("com.myproject.web.Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticFinal);
	}
}

class Initable {
	static final int staticFinal = 47;
	static final int staticFinal2 = ClassInitialization.random.nextInt(1000);
	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2 {
	static int staticFinal = 147;
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3 {
	static int staticFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}
