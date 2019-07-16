package com.bruce.demo.annotations;

import java.util.List;

public class PasswordUtils {
	private int abc = new Integer(50).intValue();
	@UseCase(id = 50,description = "Password must contain at least one nuneric")
	public boolean validatePassword(String password){
		return password.matches("\\w\\d\\w*");
	}
	
	@UseCase(id = 48)
	public String encryptPassword(String password){
		return new StringBuilder(password).reverse().toString();
	}
	
	@UseCase(id = 49, description = "New passwords can't equal previously used ones")
	public boolean checkForNewPassword(List<String> prevPasswords, String password){
		return !prevPasswords.contains(password);
	}
}
