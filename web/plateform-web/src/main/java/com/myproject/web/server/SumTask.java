package com.myproject.web.server;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 大数组求和，将大数组拆分成小数组。最后将任务结果汇总合并
 */
public class SumTask extends RecursiveTask<Long> {
	static final int THRESHOLD = 100;
	long[] array;
	int start;
	int end;

	SumTask(long[] array, int start, int end){
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		// 数组够小直接执行
		if (end - start < THRESHOLD){
			long sum = 0;
			for (int i = start; i < end; i++){
				sum += array[i];
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e){
			}
			System.out.println(String.format("%d, %d, %d", start, end, sum));
			return sum;
		}

		// 任务过大
		int middle = (start + end) / 2;
		SumTask sumTaskStart = new SumTask(array, start, middle);
		SumTask sumTaskEnd = new SumTask(array, middle, end);

		invokeAll(sumTaskStart, sumTaskEnd);
		Long sumResultStart = sumTaskStart.join();
		Long sumResultEnd = sumTaskEnd.join();

		Long result = sumResultStart + sumResultEnd;
		return result;
	}

	public static void main(String[] args) throws Exception {
		// 创建随机数组成的数组:
		long[] array = new long[400];
		fillRandom(array);
		// fork/join task:
		ForkJoinPool fjp = new ForkJoinPool(4); // 最大并发数4
		ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
		long startTime = System.currentTimeMillis();
		Long result = fjp.invoke(task);
		long endTime = System.currentTimeMillis();
		System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
	}

	public static void fillRandom(long[] array){
		Random rand = new Random();
		for (int i =0; i < array.length; i++) {
			array[i] = rand.nextInt();
		}
	}
}
