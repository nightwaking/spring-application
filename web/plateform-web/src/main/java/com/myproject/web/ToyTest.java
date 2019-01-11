package com.myproject.web;

import com.myproject.Application;

public class ToyTest {
	static void printInfo(Class cc) {
		System.out.println("Class Name:" + cc.getName() +
				" isInterface()? [" + cc.isInterface() + "]");
		System.out.println("Simple Name:" + cc.getSimpleName());
		System.out.println("Canonical Name:" + cc.getCanonicalName());
	}

	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("com.myproject.web.FancyToy");
		} catch (ClassNotFoundException e) {
			System.out.println("Can't find FancyToy");
			System.exit(1);
		}
		printInfo(c);
		for (Class face: c.getInterfaces())
			printInfo(face);
		Class up = c.getSuperclass();
		Object object = null;
		try {
			object = up.newInstance();
		} catch (InstantiationException e) {
			System.out.println("Can not instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.out.println("Can not access");
			System.exit(1);
		}
		printInfo(object.getClass());

		printSubClass(Application.class);
	}

	static void printSubClass(Class c) {
		Class superClass = c.getSuperclass();
		 if (superClass != null) {
		 	System.out.println("class 的父类:" + superClass.getCanonicalName());
			 printSubClass(superClass);
		 }
	}
}

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
	Toy() {}
	Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
	FancyToy(){
		super(1);
	}
}
