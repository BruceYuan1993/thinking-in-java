package com.bruce.demo.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {
	public static void printQ(Queue queue){
		while (queue.peek() != null) {
			System.out.println(queue.remove() + "");
		}
		System.out.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		Random random = new Random(47);
		
		for (int i = 0; i < 10; i++) {
			queue.offer(random.nextInt(i+10));
		}
		printQ(queue);
	}

}
