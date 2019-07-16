package com.bruce.demo.enumerated;
import static com.bruce.demo.enumerated.Outcome.*;

public enum RoShamBo2 implements Competitor<RoShamBo2>{
	PAPER(DRAW,LOSE,WIN),
	SCISSORS(WIN,DRAW,LOSE),
	ROCK(LOSE,WIN,DRAW)
	;
	private Outcome result_VSPaper,result_VSScissors,result_VSRock;
	private RoShamBo2(Outcome paper, Outcome scissors, Outcome rock) {
		// TODO Auto-generated constructor stub
		this.result_VSPaper = paper;
		this.result_VSScissors = scissors;
		this.result_VSRock = rock;
	}
	
	public Outcome compete(RoShamBo2 it){
		switch (it) {
		default:
		case PAPER:
			return this.result_VSPaper;
		case SCISSORS:
			return this.result_VSScissors;
		case ROCK:
			return result_VSRock;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoShamBo.play(RoShamBo2.class, 20);
	}

}
