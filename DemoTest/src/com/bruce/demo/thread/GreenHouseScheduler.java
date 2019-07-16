package com.bruce.demo.thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GreenHouseScheduler {
	private volatile boolean light = false;
	private volatile boolean water = false;
	private String thermostat = "Day";
	
	public synchronized String getThermostat(){
		return thermostat;
	}
	
	public synchronized void setThermostat(String thermostat){
		this.thermostat = thermostat;
	}
	
	ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);
	
	public void schedule(Runnable event, long period){
		scheduler.schedule(event, period, TimeUnit.MILLISECONDS);
	}
	
	
	public void repeat(Runnable event, long initialDelay, long period){
		scheduler.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MILLISECONDS);
	}
	
	
	class LightOn implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Turning on lights");
			light = true;
		}
	}
	
	class LightOff implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Turning off lights");
			light = false;
		}
	}
	
	
	class WaterOn implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Turning on Water");
			water = true;
		}
	}
	
	class WaterOff implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Turning off Water");
			water = false;
		}
	}
}
