package com.tdd.assignment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void emptyStringTest() {
		StringCalculator calculator = new StringCalculator();
		int result = calculator.add("");
		assertEquals(result, 0);
	}

	@Test
	public void singleDigitString() {
		StringCalculator calculator = new StringCalculator();
		int result = calculator.add("2");
		assertEquals(result, 2);
	}

	@Test
	public void twoDigitString() {
		StringCalculator calculator = new StringCalculator();
		int result = calculator.add("1,2");
		assertEquals(result, 3);
		int result2 = calculator.add("12,2");
		assertEquals("Adding 12,2 should give 14", result2, 14);
	}
	
	@Test
	public void multipleDigits() {
		StringCalculator calculator = new StringCalculator();
		int result = calculator.add("1,2,3,4,5");
		assertEquals(result, 15);
		int result2 = calculator.add("12,22,32,42,25");
		assertEquals(result2, 133);
	}
	
	@Test
	public void multipleDelimiter() {
		StringCalculator calculator = new StringCalculator();
		int result = calculator.add("1\n2,3");
		assertEquals(result, 6);
	}
	
	@Test
	public void inbuiltDelimiterTest() {
		StringCalculator calculator = new StringCalculator();
		int result = calculator.add("//'\n1'2'3");
		assertEquals(result, 6);
	}
	
	
	

}
