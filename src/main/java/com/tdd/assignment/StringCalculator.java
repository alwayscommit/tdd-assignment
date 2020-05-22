package com.tdd.assignment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {

	private static final String BASIC_DELIMITER = ",|\n";

	public Integer add(String numbers) {
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}

		// inbuilt delimiter
		if (hasInbuiltDelimiter(numbers)) {

			// Get Delimiter
			String[] spaceSplit = numbers.split("\n", 2);
			String delimiter = spaceSplit[0].substring(2);
			numbers = spaceSplit[1];
			return calculateSum(numbers, delimiter);
		} else {
			return calculateSum(numbers, BASIC_DELIMITER);
		}

	}

	private IntStream checkForNegatives(String[] numberStringArray) {
		String negativeNumbers = getIntegers(numberStringArray).filter(n -> n<0).mapToObj(integer -> Integer.toString(integer)).collect(Collectors.joining(","));
		if(!negativeNumbers.isEmpty()) {
			throw new UnsupportedOperationException("negatives not allowed :: " + negativeNumbers);
		} else {
			return getIntegers(numberStringArray);
		}
	}

	private Integer calculateSum(String numbers, String delimiter) {
		// split operation
		String[] numberStringArray = splitNumberString(numbers, delimiter);

		//check for negatives
		IntStream posIntStream = checkForNegatives(numberStringArray);

		// perform summation
		return posIntStream.sum();
	}

	private boolean hasInbuiltDelimiter(String numbers) {
		return numbers.startsWith("//");
	}

	private IntStream getIntegers(String[] numberStringArray) {
		return Arrays.stream(numberStringArray).mapToInt(Integer::parseInt);
	}

	private String[] splitNumberString(String numbers, String delimiter) {
		return numbers.split(delimiter);
	}

}
