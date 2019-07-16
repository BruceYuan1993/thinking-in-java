package com.bruce.demo.enumerated;

public enum PayrollDay {
	MONDAY(PayType.WEEKDAY),
	TUESDAY(PayType.WEEKDAY),
	WEDNESDAY(PayType.WEEKDAY),
	THURSDAY(PayType.WEEKDAY),
	FRIDAY(PayType.WEEKDAY),
	SATURDAY(PayType.WEEKEND),
	SUNDAY(PayType.WEEKEND)
	;
	private final PayType payType;
	PayrollDay(PayType payType){
		this.payType = payType;
	}
	
	double pay(double hoursWorked, double payRate){
		return payType.pay(hoursWorked, payRate);
	}
	
	private enum PayType{
		WEEKDAY {
			@Override
			public double overtimePay(double hrs, double payRate) {
				// TODO Auto-generated method stub
				return hrs <= HOUR_PER_SHIFT ? 0 :(hrs - HOUR_PER_SHIFT)*payRate /2;
			}
		},
		WEEKEND {
			@Override
			public double overtimePay(double hrs, double payRate) {
				// TODO Auto-generated method stub
				return hrs * payRate /2;
			}
		};
		private static final int HOUR_PER_SHIFT = 8;
		
		abstract double overtimePay(double hrs, double payRate);
		
		double pay(double hoursWorked, double payRate){
			double basePaty = hoursWorked * payRate;
			return basePaty + overtimePay(hoursWorked, payRate);
		}
	}
}
