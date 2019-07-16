package com.bruce.demo.enumerated;

import java.util.EnumSet;
public class EnumSets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
		points.add(AlarmPoints.BATHROOM);
		System.out.println(points);
		points.addAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2,AlarmPoints.KITCHEN));
		System.out.println(points);
		points = EnumSet.allOf(AlarmPoints.class);
		System.out.println(points);
		points.removeAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2,AlarmPoints.KITCHEN));
		System.out.println(points);
		points.removeAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
		System.out.println(points);
		points = EnumSet.complementOf(points);
		System.out.println(points);
		System.out.println(points.remove(null));;
	}
}

enum AlarmPoints{
	STAIR1,STAIR2,LOBBY,OFFICE1,
	OFFICE2,OFFICE3,OFFICE4,BATHROOM,
	UTILITY,KITCHEN
}
