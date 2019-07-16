package com.bruce.demo.enumerated;

import java.text.DateFormat;
import java.util.Date;

public enum ConstantSpecificMethod {
	DATE_TIME{

		@Override
		public String getInfo() {
			// TODO Auto-generated method stub
			return DateFormat.getDateInstance().format(new Date());
		}
		
	},
	CLASSPATH {
		@Override
		public String getInfo() {
			// TODO Auto-generated method stub
			return System.getenv("ClassPath");
		}
	},
	VERSION{
		@Override
		public String getInfo(){
			return System.getProperty("java.version");
			
		}
	}
	;
	abstract String getInfo();
	public static void main(String[] args) {
		for (ConstantSpecificMethod cps : values()) {
			System.out.println(cps.getInfo());
		}
	}
}
