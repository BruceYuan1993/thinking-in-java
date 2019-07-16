package com.bruce.demo.collection;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import com.bruce.demo.generics.Generator;

public class QueueBehavior {
	static class Gen implements Generator<String>{
		String[] ss ="one two three four five six seven eight nine ten".split(" ");
		int i;
		@Override
		public String next() {
			// TODO Auto-generated method stub
			return ss[i++];
		}
	}
	
	static <T> void test(Queue<T> queue, Generator<T> gen){
		for(int i = 0; i< count; i++){
			queue.offer(gen.next());
		}
		while (queue.peek() != null) {
			System.out.print(queue.remove() + " ");
		}
		System.out.println();
	}
	
	private static int count = 10;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test(new LinkedList<String>(), new Gen());
		test(new PriorityQueue<String>(), new Gen());
		test(new ArrayBlockingQueue<String>(count), new Gen());
		test(new ConcurrentLinkedQueue<String>(), new Gen());
		test(new LinkedBlockingQueue<String>(), new Gen());
		test(new PriorityBlockingQueue<String>(), new Gen());
	}

}
