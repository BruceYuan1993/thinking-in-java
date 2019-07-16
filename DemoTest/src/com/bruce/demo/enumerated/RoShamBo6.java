package com.bruce.demo.enumerated;
import static com.bruce.demo.enumerated.Outcome.*;
public enum RoShamBo6 implements Competitor<RoShamBo6>{
	PAPER,
	SCISSORS,
	ROCK;
	private static Outcome[][] table = {
		{ DRAW,LOSE,WIN },
		{ WIN,DRAW,LOSE },
		{ LOSE,WIN,DRAW }
	};
	@Override
	public Outcome compete(RoShamBo6 t) {
		// TODO Auto-generated method stub
		return table[ordinal()][t.ordinal()];
	}
	public static void main(String[] args) {
		RoShamBo.play(RoShamBo5.class, 20);
	}
}
