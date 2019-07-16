package com.bruce.demo.designpattern.staticfactory;

public class LoginManager {
	public static Login factory(String type){
		Login login = null;
		if ("password".equals(type)) {
			login = new PasswordLogin();
		}else if ("domain".equals(type)) {
			login = new DomainLogin();
		}else {
			throw new RuntimeException("not found type");
		}
		return login;
	}
}
