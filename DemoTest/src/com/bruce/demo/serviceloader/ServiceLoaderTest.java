package com.bruce.demo.serviceloader;

import java.util.ServiceLoader;

public class ServiceLoaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(IService.class.getName());
		ServiceLoader<IService> loader = ServiceLoader.load(IService.class);
		
		for (IService is : loader){
			System.out.println(is.sayHello());
		}
	}

}
