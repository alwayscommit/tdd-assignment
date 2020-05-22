package com.tdd.assignment;

public class StringCalculator {

	public Integer add(String numbers) {
		
		if(numbers==null || numbers=="") {
			return 0;
		}
		
		String[] numberStringArray = numbers.split(",");
		if (numberStringArray.length == 1) {
			return Integer.parseInt(numberStringArray[0]);
		} else {
			int num1 = Integer.parseInt(numberStringArray[0]);
			int num2 = Integer.parseInt(numberStringArray[1]);
			return num1 + num2;
		}
	}

}
