package com.tdd.assignment;

public class LeapYearKataApp {

	public boolean isLeapYear(int year) {
		
		if(year==0) {
			return false;
		}

		boolean isLeapYear = isDivisibleBy400(year);

		if (!isLeapYear) {
			isLeapYear = divisibleBy4ButNot100(year);
		}

		return isLeapYear;
	}

	private boolean divisibleBy4ButNot100(int year) {
		if (disibleBy4(year) && notDivisibleBy100(year)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean notDivisibleBy100(int year) {
		return year % 100 != 0;
	}

	private boolean isDivisibleBy400(int year) {
		return (year % 400) == 0;
	}

	private boolean disibleBy4(int year) {
		return year % 4 == 0;
	}

}
