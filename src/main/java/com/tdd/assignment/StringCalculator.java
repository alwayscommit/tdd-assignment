package com.tdd.assignment;

public class StringCalculator {

	public Integer calculateString(String numberString) {
		
		if(numberString==null || numberString.equals("")) {
			return 0;
		} else {
			int number = Integer.parseInt(numberString);
			return number;
		}
		
	}

}
