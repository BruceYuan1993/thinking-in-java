package com.bruce.demo.exception;

class BaseballException extends Exception {}
class Foul extends BaseballException{}
class Strike extends BaseballException{}

abstract class Inning{
	public Inning() throws BaseballException{
		throw new BaseballException();
	}
	public void event() throws BaseballException{
		
	}
	
	public abstract void atBat() throws Foul,Strike;
	
	public void walk(){};
}

class StormException extends Exception {}
class RainedOut extends StormException{}
class PopFoul extends Foul{}


interface Storm{
	//public void event() throws RainedOut;
	public void rainHard() throws StormException;
}

public class StromyInning extends Inning implements Storm{
	public StromyInning() throws RainedOut,BaseballException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StromyInning(String s) throws Foul,BaseballException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//@Override
	//public  void event() throws RainedOut,BaseballException{}
	
	@Override
	public void atBat() throws PopFoul{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rainHard() throws RainedOut{
		// TODO Auto-generated method stub
		
	}
	
	public  void event(){};
	//public void walk() throws PopFoul{};
	
	public static void main(String[] args) {
		try {
			StromyInning si = new StromyInning();
			si.atBat();
		} catch (PopFoul e) {
			// TODO: handle exception
			System.out.println("1");
		} catch (RainedOut e) {
			// TODO: handle exception
			System.out.println("2");
		} catch (BaseballException e) {
			// TODO: handle exception
			System.out.println("3");
		}
		
		try {
			Inning ii = new StromyInning();
			ii.atBat();
		} catch (BaseballException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RainedOut e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
