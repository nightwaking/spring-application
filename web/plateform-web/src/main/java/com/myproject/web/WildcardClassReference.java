package com.myproject.web;

public class WildcardClassReference {
	public static void main(String[] args) {
		Class<?> intClass = int.class;
		intClass = double.class;
	}
}
