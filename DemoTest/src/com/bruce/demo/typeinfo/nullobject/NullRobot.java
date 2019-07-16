package com.bruce.demo.typeinfo.nullobject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

class NullRobotProxyHandler implements InvocationHandler{
	private String nullName;
	private Object proxied = new NRobot();
	NullRobotProxyHandler(Class<? extends Robot> type){
		nullName = type.getSimpleName() + " NullRobot";
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		return method.invoke(proxied, args);
	}
	private class NRobot implements Null,Robot{

		@Override
		public String model() {
			// TODO Auto-generated method stub
			return nullName;
		}

		@Override
		public String name() {
			// TODO Auto-generated method stub
			return nullName;
		}

		@Override
		public List<Operation> operations() {
			// TODO Auto-generated method stub
			return Collections.emptyList();
		}
		
	}
}
public class NullRobot {
	public static Robot newNullRobot(Class<? extends Robot> type){
		return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(), 
				new Class<?>[]{ Null.class, Robot.class}, 
				new NullRobotProxyHandler(type));
	}
	public static void main(String[] args) {
		Robot[] bots = {
				new SnowRemovalRobot("SnowBee"),
				newNullRobot(SnowRemovalRobot.class)
		};
//		for (Robot robot : bots) {
//			Robot.Test.test(robot);
//		}
		Robot r1 = newNullRobot(SnowRemovalRobot.class);
		Robot r2 = newNullRobot(SnowRemovalRobot.class);
		System.out.println(r1.getClass() == r2.getClass());
		System.out.println(r2 == r1);
		System.out.println(r2.equals(r1));
	}
}
