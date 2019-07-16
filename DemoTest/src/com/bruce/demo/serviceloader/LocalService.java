package com.bruce.demo.serviceloader;

public class LocalService implements IService{

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hello Local";
	}

	@Override
	public String getScheme() {
		// TODO Auto-generated method stub
		return "Local";
	}

}
