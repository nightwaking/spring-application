package com.myproject.web.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixPoolDemo {
	public static Runnable getThread(final int i) {
		return new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(i);
			}
		};
	}

	public static void main(String[] args) {
		ExecutorService fixPool = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			fixPool.execute(getThread(i));
		}
		fixPool.shutdown();
	}
}
