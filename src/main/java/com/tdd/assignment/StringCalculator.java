package com.tdd.assignment;

public class StringCalculator {

	public Integer add(String numberString) {

		if (numberString == null || numberString.equals("")) {
			return 0;
		} else {
			String[] numberStringArray = numberString.split(",");

			if(numberStringArray.length<2) {
				return Integer.parseInt(numberStringArray[0]);
			}
			
			int num1 = Integer.parseInt(numberStringArray[0]);
			int num2 = Integer.parseInt(numberStringArray[1]);

			return num1 + num2;
		}
	}

}
