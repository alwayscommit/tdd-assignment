package com.tdd.assignment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void emptyStringTest() {
		StringCalculator calculator = new StringCalculator();
		int result = calculator.calculateString("");
		assertEquals(result, 0);
	}
	
	@Test
	public void nonEmptyStringTest() {
		StringCalculator calculator = new StringCalculator();
		int result = calculator.calculateString("2");
		assertEquals(result, 2);
	}
	
	
}
