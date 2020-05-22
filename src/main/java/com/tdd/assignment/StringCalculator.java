package com.tdd.assignment;

import java.util.Arrays;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.stream.IntStream;

public class StringCalculator {

	private static final String BASIC_DELIMITER = ",|\n";
	private static final String EMPTY_STRING = "";

	public Integer add(String numbers) {
		if (numbers == null || numbers == EMPTY_STRING) {
			return 0;
		}

		// inbuilt delimiter
		if (hasInbuiltDelimiter(numbers)) {

			String[] spaceSplit = numbers.split("\n", 2);
			String delimiter = spaceSplit[0].substring(2);
			numbers = spaceSplit[1];
			String[] numberStringArray = numbers.split(delimiter);
			IntStream intStream = getIntegers(numberStringArray);
			return intStream.sum();
		} else {
			// split operation
			String[] numberStringArray = splitNumberString(numbers);

			// convert to int operation
			IntStream intStream = getIntegers(numberStringArray);

			// perform summation
			return intStream.sum();
		}

	}

	private boolean hasInbuiltDelimiter(String numbers) {
		return numbers.startsWith("//");
	}

	private IntStream getIntegers(String[] numberStringArray) {
		return Arrays.stream(numberStringArray).mapToInt(Integer::parseInt);
	}

	private String[] splitNumberString(String numbers) {
		return numbers.split(BASIC_DELIMITER);
	}

}
