package com.myproject.web.server;

public class AppThread {
	public static void main(String[] args) throws Exception{
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("线程执行");
			}
		}).start();
	}
}
