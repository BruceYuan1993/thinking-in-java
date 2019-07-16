package com.bruce.demo.annotations.apt;

@ExtractInterface("IMultiplier")
public class Multiplier {
	public int multiplier(int x, int y){
		int total = 0;
		for (int i = 0; i< x; i++){
			total = add(total, y);
		}
		return total;
	}
	
	private int add(int x,int y){
		return x + y;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Multiplier multiplier = new Multiplier();
		System.out.println("11 * 16 = " + multiplier.multiplier(11, 16));
	}

}
