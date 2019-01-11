package com.myproject.web;

import com.myproject.Application;
import org.springframework.boot.SpringApplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassRun {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		Class application = Application.class;
		System.out.println(application.getSimpleName());

		// 每当编写或编译一个新类就会产生一个Class对象
		List<Shape> shapes = Arrays.asList(Circle.class.newInstance(), Square.class.newInstance(), Triangle.class.newInstance());
		for (Shape shape: shapes)
			shape.draw();
	}
}

abstract class Shape {
	void draw() {
		System.out.println(this + ".draw()");
	};
	abstract public String toString();
}

class Circle extends Shape {
	public String toString() {
		return "Circle";
	}
}

class Square extends Shape {
	public String toString() {
		return "Square";
	}
}

class Triangle extends Shape {
	public String toString() {
		return "Triangle";
	}
}
