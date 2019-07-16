package com.bruce.demo.enumerated;

import java.util.EnumMap;
import static com.bruce.demo.enumerated.Outcome.*;

public enum RoShamBo5 implements Competitor<RoShamBo5>{
	PAPER,
	SCISSORS,
	ROCK;	
	static EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>>
	table = new EnumMap<RoShamBo5, EnumMap<RoShamBo5,Outcome>>(RoShamBo5.class);
	static{
		for(RoShamBo5 it : RoShamBo5.values()){
			table.put(it, 
			new EnumMap<RoShamBo5, Outcome>(RoShamBo5.class)
			);
		}
		initRow(PAPER, DRAW, LOSE, WIN);
		initRow(SCISSORS, WIN, DRAW, LOSE);
		initRow(ROCK, LOSE, WIN, DRAW);
	}
	
	static void initRow(RoShamBo5 it, Outcome result_VSPaper, Outcome result_VSSCISSORS,Outcome result_VSRock){
		EnumMap<RoShamBo5, Outcome> row = table.get(it);
		row.put(PAPER, result_VSPaper);
		row.put(SCISSORS, result_VSSCISSORS);
		row.put(ROCK, result_VSRock);
	}
	
	@Override
	public Outcome compete(RoShamBo5 t) {
		// TODO Auto-generated method stub
		return table.get(this).get(t);
	}
	
	public static void main(String[] args) {
		RoShamBo.play(RoShamBo5.class, 20);
	}

}
