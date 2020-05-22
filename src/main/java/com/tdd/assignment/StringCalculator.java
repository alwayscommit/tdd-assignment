package com.tdd.assignment;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringCalculator {
	
	private static final String BASIC_DELIMITER = ",|\n";
	private static final String EMPTY_STRING = "";

	public Integer add(String numbers) {
		if (numbers == null || numbers == EMPTY_STRING) {
			return 0;
		}
		//split operation
		String[] numberStringArray = splitNumberString(numbers);
		
		//convert to int operation
		IntStream intStream = getIntegers(numberStringArray);
		
		//perform summation
		return intStream.sum();
	}

	private IntStream getIntegers(String[] numberStringArray) {
		return Arrays.stream(numberStringArray).mapToInt(Integer::parseInt);
	}

	private String[] splitNumberString(String numbers) {
		return numbers.split(BASIC_DELIMITER);
	}

}
