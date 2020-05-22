package com.tdd.assignment;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringCalculator {

	public Integer add(String numbers) {
		if (numbers == null || numbers == "") {
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
		return numbers.split(",|\n");
	}

}
