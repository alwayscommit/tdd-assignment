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
	
	
}
