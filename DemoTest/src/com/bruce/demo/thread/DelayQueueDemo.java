package com.bruce.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class DelayedTask implements Runnable, Delayed {
	private static int counter = 0;
	private final int id = counter++;
	private final int delta;
	private final long trigger;
	protected static List<DelayedTask> sequence = new ArrayList<DelayedTask>();

	public DelayedTask(int delta) {
		super();
		this.delta = delta;
		trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS);
		sequence.add(this);
	}

	@Override
	public int compareTo(Delayed o) {
		// TODO Auto-generated method stub
		DelayedTask that = (DelayedTask) o;
		if (trigger < that.trigger)
			return -1;
		if (trigger > that.trigger)
			return 1;
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this + " ");
	}

	@Override
	public String toString() {
		return "(" + id + " : " + delta + ")";
	}

	public static class EndSentinel extends DelayedTask {
		private ExecutorService exec;

		public EndSentinel(int delta, ExecutorService e) {
			super(delta);
			// TODO Auto-generated constructor stub
			exec = e;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (DelayedTask pt : sequence) {
				System.out.println(pt.toString() + " ");
			}
			System.out.println(this + " calling shutdownNow() ");
			exec.shutdownNow();
		}
	}
}

class DelayedTaskConsumer implements Runnable {
	private DelayQueue<DelayedTask> q;

	public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
		super();
		this.q = q;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			while (!Thread.interrupted()) {
				q.take().run();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finished DelayedTaskConsumer");
	}
}

public class DelayQueueDemo {
	public static void main(String[] args) {
		Random random = new Random(47);
		ExecutorService exec = Executors.newCachedThreadPool();
		DelayQueue<DelayedTask> queue = new DelayQueue<>();

		for (int i = 0; i < 20; i++) {
			queue.put(new DelayedTask(random.nextInt(5000)));
		}

		queue.add(new DelayedTask.EndSentinel(5001, exec));

		exec.execute(new DelayedTaskConsumer(queue));
	}
}
