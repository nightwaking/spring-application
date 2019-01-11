package com.myproject.web.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {
	private static LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue();

	public static void main(String[] args) {
		// 固定线程数的线程池
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.submit(new Producer("producer1"));
		executorService.submit(new Producer("producer2"));
		executorService.submit(new Producer("producer3"));
		executorService.submit(new Consumer("consumer1"));
		executorService.submit(new Consumer("consumer2"));
		executorService.submit(new Consumer("consumer3"));
	}

	static class Producer implements Runnable {
		private String name;

		public Producer(String name) {
			this.name = name;
		}

		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(name + "生产:" + i);
				try {
					blockingQueue.put(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class Consumer implements Runnable {
		private String name;

		private Consumer(String name) {
			this.name = name;
		}

		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println(name + "消费:" + blockingQueue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
