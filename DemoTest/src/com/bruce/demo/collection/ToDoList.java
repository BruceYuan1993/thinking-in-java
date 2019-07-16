package com.bruce.demo.collection;

import java.util.PriorityQueue;

public class ToDoList extends PriorityQueue<ToDoList.ToDoItem>{
	static class ToDoItem implements Comparable<ToDoItem>{
		private char primary;
		private int secondary;
		private String item;
		
		public ToDoItem(String item, char primary, int secondary) {
			this.primary = primary;
			this.secondary = secondary;
			this.item = item;
		}

		@Override
		public int compareTo(ToDoItem o) {
			// TODO Auto-generated method stub
			if (primary > o.primary)
				return 1;
			if (primary == o.primary){
				if (secondary > o.secondary){
					return 1;
				} else if (secondary == o.secondary) {
					return 0;
				}
			}
			return -1;
		}

		@Override
		public String toString() {
			return "ToDoItem [item=" + item + ", primary=" + primary
					+ ", secondary=" + secondary + "]";
		}
	}
	
	public void add(String td, char pri, int sec){
		super.add(new ToDoItem(td, pri, sec));
	}
	
	public static void main(String[] args) {
		ToDoList list = new ToDoList();
		list.add("Empty Trah", 'C', 4);
		list.add("Feed Dog", 'A', 2);
		list.add("Feed Bird", 'B', 7);
		list.add("Mow  lawn", 'C', 3);
		list.add("Water lawn", 'A', 1);
		list.add("Feed CAT", 'B', 1);
		
		while (!list.isEmpty()) {
			System.out.println(list.remove());
		}
	}
}
