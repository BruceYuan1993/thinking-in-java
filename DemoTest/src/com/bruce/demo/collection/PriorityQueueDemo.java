package com.bruce.demo.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>();
		Random random = new Random(47);
		
		for (int i = 0; i < 10; i++) {
			queue1.offer(random.nextInt(i+10));
		}
		
		QueueDemo.printQ(queue1);
		
		
		List<Integer> ints = Arrays.asList(25,22,20,18,14,9,3,1,1,2,3,9);
		
		PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder());
		queue2.addAll(ints);
		QueueDemo.printQ(queue2);
	}
}
