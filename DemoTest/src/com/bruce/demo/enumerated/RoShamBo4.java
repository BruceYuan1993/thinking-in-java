package com.bruce.demo.enumerated;
import static com.bruce.demo.enumerated.Outcome.*;
public enum RoShamBo4 implements Competitor<RoShamBo4> {
	PAPER{

		@Override
		public Outcome compete(RoShamBo4 t) {
			// TODO Auto-generated method stub
			return compete(SCISSORS, t);
		}
		
	}, 
	SCISSORS{

		@Override
		public Outcome compete(RoShamBo4 t) {
			// TODO Auto-generated method stub
			return compete(ROCK, t);
		}
		
	}, 
	ROCK{

		@Override
		public Outcome compete(RoShamBo4 t) {
			// TODO Auto-generated method stub
			return compete(PAPER, t);
		}
		
	}
	;

	public Outcome compete(RoShamBo4 loser, RoShamBo4 opponent) {
		// TODO Auto-generated method stub
		return (opponent == this)? DRAW :
			(opponent == loser) ? LOSE : WIN;
			
	}
	public static void main(String[] args) {
		RoShamBo.play(RoShamBo4.class, 20);
	}
}
