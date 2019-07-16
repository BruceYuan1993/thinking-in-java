package com.bruce.demo.typeinfo;

import java.util.ArrayList;
import java.util.List;


class CountedInteger{
	private static long counter;
	private final long id= counter++;
	@Override
	public String toString() {
		return Long.toString(id);
	}
	
}
public class FilledList<T> {
	private Class<T> type;
	public FilledList(Class<T> type){
		this.type = type;
	}
	public List<T> create(int count){
		List<T> result = new ArrayList<T>();
		try {
			for (int i = 0; i < count; i++) {
				result.add(type.newInstance());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
		System.out.println(fl.create(15));
	}

}
