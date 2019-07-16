package com.bruce.demo.enumerated;
enum Signal{
	GREEN, YELLOW, RED
}
public class TrafficLight {
	Signal color = Signal.RED;
	public void change(){
		switch (color){
			case RED:
				color = Signal.GREEN;
				break;
			case GREEN:
				color = Signal.YELLOW;
				break;
			case YELLOW:
				color = Signal.RED;
				break;
			
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "The traffic light is " + color;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrafficLight t = new TrafficLight();
		for(int i=0; i<7; i++){
			System.out.println(t);
			t.change();
		}
	}

}
