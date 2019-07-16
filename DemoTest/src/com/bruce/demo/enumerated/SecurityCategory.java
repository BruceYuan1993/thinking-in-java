package com.bruce.demo.enumerated;

import com.bruce.demo.util.Enums;

public enum SecurityCategory {
	STOCK(Security.Stock.class),
	BOND(Security.Bond.class),
	;
	interface Security {
		enum Stock implements Security{
			SHORT, LONG, MARGIN
		}
		
		enum Bond implements Security{
			MUNICIPAL, JUNK
		}
	}
	
	private Security[] values;
	
	private SecurityCategory(Class<? extends Security> kind){
		values = kind.getEnumConstants();
	}
	
	public Security randomSelection(){
		return Enums.random(values);
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			SecurityCategory security = Enums.random(SecurityCategory.class);
			System.out.println(security + ": " + security.randomSelection());
		}
	}
	
}
