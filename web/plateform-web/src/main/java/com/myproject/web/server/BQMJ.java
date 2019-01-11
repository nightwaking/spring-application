package com.myproject.web.server;

public class BQMJ {
	public static void main(String[] args) {
		int cook, hen, chicken;
		for (cook = 0; cook <= 19; cook++){
			for (hen = 0; hen<= 33; hen++) {
				chicken = 100 - hen - cook;
				if (((cook * 5 + hen * 3 + chicken / 3) == 100) && (chicken % 3) == 0) {
					System.out.println("cook: " + cook);
					System.out.println("hen: " + hen);
					System.out.println("chicken: " + chicken);
				}
			}
		}
	}
}
