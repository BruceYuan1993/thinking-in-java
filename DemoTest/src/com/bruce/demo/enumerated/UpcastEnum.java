package com.bruce.demo.enumerated;

public class UpcastEnum {
	enum Search{
		HITHER,YON
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search[] vals=Search.values();
		Enum<?> e = Search.HITHER;
		for(Enum<?> o : e.getClass().getEnumConstants()){
			System.out.println(o.name() +"  " +o.ordinal());
		}
	}

}
