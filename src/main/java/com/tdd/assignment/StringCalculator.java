package com.tdd.assignment;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {

	private static final String BASIC_DELIMITER = ",|\n";
	private int count = 0;

	public Integer add(String numbers) {
		count++;
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}

		// Get Delimiter
		String[] delimiterAndNumberArray = numbers.split("\n", 2);

		if (hasInbuiltDelimiter(numbers)) { 
			delimiterAndNumberArray = numbers.split("\n", 2);
			String delimiter = getDelimiter(delimiterAndNumberArray[0]);
			numbers = delimiterAndNumberArray[1];
			return calculateSum(numbers, delimiter);
		} else {
			return calculateSum(numbers, BASIC_DELIMITER);
		}

	}

	private String getDelimiter(String delimiterPart) {

		// delimiter string starts with //[
		if (delimiterPart.startsWith("//[")) {
			return delimiterPart.substring(3, delimiterPart.length() - 1);
		} else {
			// delimiter string starts with // only
			return delimiterPart.substring(2);
		}
	}

	private Integer calculateSum(String numbers, String delimiter) {
		// split operation
		String[] numberStringArray = splitNumberString(numbers, delimiter);

		// check for negatives
		IntStream posIntStream = checkForNegatives(numberStringArray);

		// ignore number > 1000
		IntStream finaIntStream = limitMaxNumber(posIntStream);

		// perform summation
		return finaIntStream.sum();
	}

	private IntStream limitMaxNumber(IntStream posIntStream) {
		return posIntStream.filter(num -> num < 1000);
	}

	private boolean hasInbuiltDelimiter(String numbers) {
		return numbers.startsWith("//");
	}

	private IntStream getIntegers(String[] numberStringArray) {
		return Arrays.stream(numberStringArray).mapToInt(Integer::parseInt);
	}

	private String[] splitNumberString(String numbers, String delimiter) {
		return numbers.split("\\" + delimiter);
	}

	public int getCalledCount() {
		return count;
	}

	private IntStream checkForNegatives(String[] numberStringArray) {
		String negativeNumbers = getIntegers(numberStringArray).filter(n -> n < 0)
				.mapToObj(integer -> Integer.toString(integer)).collect(Collectors.joining(","));
		if (!negativeNumbers.isEmpty()) {
			throw new UnsupportedOperationException("negatives not allowed :: " + negativeNumbers);
		} else {
			return getIntegers(numberStringArray);
		}
	}

}
