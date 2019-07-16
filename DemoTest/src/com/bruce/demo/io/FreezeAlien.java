package com.bruce.demo.io;

public class FreezeAlien {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		
		StringBuffer buffer = new StringBuffer();
		
		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, 0);
		
		System.out.println(p1);
		System.out.println(p2);
		
		test(p1, p2);
		
		
		System.out.println(p1);
		System.out.println(p2);
	}
	private static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
	//public static badSwap
	
	public static void test(Point p1, Point p2) {
		p1.x = 100;
		p1.y = 100;
		
		Point temp = p1;
		p1 = p2;
		p2 = temp;
		System.out.println("-----------------");
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println("-----------------");
	}
}
