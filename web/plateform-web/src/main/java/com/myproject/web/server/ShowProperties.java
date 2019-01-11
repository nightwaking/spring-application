package com.myproject.web.server;

import java.util.ArrayList;
import java.util.Random;

public class ShowProperties {
	public static void main(String[] args) {
		System.getProperties().list(System.out);
		System.out.println(" || ");
		System.out.println(System.getProperty("user.name"));
		System.out.println(" || ");
		System.out.println(System.getProperty("java.library.path"));
		System.out.println(new Integer(45) ==  new Integer(45));
		System.out.println((1 << 8 &0xff00));
		System.out.println(1 & 0xff);
		System.out.println(1 << 16 & 0xff0000);
		System.out.println(1 << 24 & 0xff000000);
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(1));
		System.out.println(Integer.MAX_VALUE * 4);

		for (char i = 0; i < 128; i++) {
			if (Character.isLowerCase(i))
				System.out.println("value: " + (int)i + "character: " + i);
		}

		int next = 0;
		ArrayList<Integer> lts = new ArrayList<>();
		ArrayList<Integer> gts = new ArrayList<>();
		ArrayList<Integer> eqs = new ArrayList<>();
		Random random = new Random(10);

		for (int i = 0; i < 25; i++){
			int result = random.nextInt(100);
			if (i == 0) {
				next = result;
				eqs.add(result);
				continue;
			}
			if (result > next)
				gts.add(result);
			else if (result < next)
				lts.add(result);
			else
				eqs.add(result);
			next = result;
		}
	}
	public void pick() {

	}

	void pit() {
		pick();
	}
}
