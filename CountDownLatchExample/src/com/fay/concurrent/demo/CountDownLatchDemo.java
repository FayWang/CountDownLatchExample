package com.fay.concurrent.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fay.concurrent.Boss;
import com.fay.concurrent.Worker;

public class CountDownLatchDemo {

	public CountDownLatchDemo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		CountDownLatch latch = new CountDownLatch(3);

		Worker w1 = new Worker(latch, "张三");
		Worker w2 = new Worker(latch, "李四");
		Worker w3 = new Worker(latch, "王二");
		System.out.println(latch.getCount());
		Boss boss = new Boss(latch);

		executor.execute(w3);
		executor.execute(w2);
		executor.execute(w1);
		executor.execute(boss);

		executor.shutdown();
	}

}
