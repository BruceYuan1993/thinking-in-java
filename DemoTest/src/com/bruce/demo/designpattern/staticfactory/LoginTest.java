package com.bruce.demo.designpattern.staticfactory;

public class LoginTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String loginType = "password";
		String userName = "userName";
		String password = "password";
		Login login = LoginManager.factory(loginType);
		System.out.println(login.getClass().getSimpleName());
		if (login.verify(userName, password)) {
			System.out.println("Login sucessfuly");
		}else {
			System.out.println("Login failed");
		}
	}

}
