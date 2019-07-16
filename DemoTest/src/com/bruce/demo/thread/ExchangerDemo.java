package com.bruce.demo.thread;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.bruce.demo.generics.BasicGenerator;
import com.bruce.demo.generics.Generator;

class ExchangerProducer<T> implements Runnable{
	private Generator<T> generator;
	private Exchanger<List<T>> exchager;
	private List<T> holder;
	public ExchangerProducer(Generator<T> generator, Exchanger<List<T>> exchager, List<T> holder) {
		super();
		this.generator = generator;
		this.exchager = exchager;
		this.holder = holder;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
			try {
				while (!Thread.interrupted()) {
					for (int i=0; i<10; i++)
						holder.add(generator.next());
				holder = exchager.exchange(holder);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
}


class ExchangerConsumer<T> implements Runnable{
	private Exchanger<List<T>> exchager;
	private List<T> holder;
	private volatile T value;
	public ExchangerConsumer(Exchanger<List<T>> exchager, List<T> holder) {
		super();
		this.exchager = exchager;
		this.holder = holder;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
			try {
				while (!Thread.interrupted()) {
					holder = exchager.exchange(holder);
					for(T x : holder){
						value = x;
						holder.remove(x);
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Final value : " + value);
	}
	
}

public class ExchangerDemo {
	static int delay = 10;
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		Exchanger<List<Fat>> xc = new Exchanger<>();
		
		List<Fat> producerList = new CopyOnWriteArrayList<>();
		List<Fat> comsumerList = new CopyOnWriteArrayList<>();
		
		exec.execute(new ExchangerProducer(BasicGenerator.create(Fat.class), xc, producerList));
		
		exec.execute(new ExchangerConsumer(xc, comsumerList));
		
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}
	
}
