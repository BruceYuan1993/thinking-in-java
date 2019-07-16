package com.bruce.demo.enumerated;

import java.util.EnumMap;
import java.util.Map.Entry;

import static com.bruce.demo.enumerated.AlarmPoints.*;
interface Command{
	void action();
}
public class EnumMaps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
		em.put(KITCHEN, new Command() {
			
			@Override
			public void action() {
				// TODO Auto-generated method stub
				System.out.println("Kitchen Fire");
			}
		});
		em.put(BATHROOM, new Command() {
			
			@Override
			public void action() {
				// TODO Auto-generated method stub
				System.out.println("Bathroom alert");
			}
		});
		em.entrySet();
		for (Entry<AlarmPoints, Command> e: em.entrySet()) {
			System.out.print(e.getKey() + ":");
			e.getValue().action();
		}
		try {
			em.get(123).action();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
