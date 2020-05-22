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
	
	
}
