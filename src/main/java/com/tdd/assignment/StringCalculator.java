package com.tdd.assignment;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringCalculator {

	public Integer add(String numbers) {
		if (numbers == null || numbers == "") {
			return 0;
		}
		String[] numberStringArray = numbers.split(",");
		IntStream intStream = Arrays.stream(numberStringArray).mapToInt(Integer::parseInt);
		int sum = intStream.sum();
		return sum;
	}

}
