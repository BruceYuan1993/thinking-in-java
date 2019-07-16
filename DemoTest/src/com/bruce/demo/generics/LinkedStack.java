package com.bruce.demo.generics;



public class LinkedStack<T> {
//	private static class Node<U> {
//		U value;
//		Node<U> next;
//		Node(){
//			this.next = null;
//			this.value = null;
//		}
//		Node(U value, Node<U> next){
//			this.next = next;
//			this.value = value;
//		}
//		boolean isEnd(){
//			return value==null && next == null;
//		}
//	}
	
	private class Node {
		T value;
		Node next;
		Node(){
			this.next = null;
			this.value = null;
		}
		Node(T value, Node next){
			this.next = next;
			this.value = value;
		}
		boolean isEnd(){
			return value==null && next == null;
		}
	}
	
	private Node top = new Node();
	
	public void push(T value){
		top = new Node(value, top);
	}
	
	public T pop(){
		T result = top.value;
		if (!top.isEnd()){
			top = top.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<String>();
		for (String s : "Phasers on stun!".split(" ")) {
			lss.push(s);
		}
		String s;
		while ((s=lss.pop()) != null) {
			System.out.println(s);
		}
		
		LinkedStack<Integer> lsi = new LinkedStack<Integer>();
		lsi.push(1);
		lsi.push(2);
		
		System.out.println(lsi.pop());
		System.out.println(lsi.pop());
	}
}
