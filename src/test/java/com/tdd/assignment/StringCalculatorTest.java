package com.tdd.assignment;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator calculator;

	private static int addMethodCounter = 0;
	
	@Before
	public void setup() {
		calculator = new StringCalculator();
	}

	@Test
	public void emptyStringTest() {
		int result = calculator.add("");
		assertEquals(result, 0);
	}

	@Test
	public void singleDigitString() {
		int result = calculator.add("2");
		assertEquals(result, 2);
	}

	@Test
	public void twoDigitString() {
		int result = calculator.add("1,2");
		assertEquals(result, 3);
		int result2 = calculator.add("12,2");
		assertEquals("Adding 12,2 should give 14", result2, 14);
	}

	@Test
	public void multipleDigits() {
		int result = calculator.add("1,2,3,4,5");
		assertEquals(result, 15);
		int result2 = calculator.add("12,22,32,42,25");
		assertEquals(result2, 133);
	}

	@Test
	public void multiplePredefinedDelimiter() {
		int result = calculator.add("1\n2,3");
		assertEquals(result, 6);
	}

	@Test
	public void inbuiltDelimiterTest() {
		int result = calculator.add("//'\n1'2'3");
		assertEquals(result, 6);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void negativeNumberTest() {
		int result = calculator.add("//'\n-1'-2'-3");
		assertEquals(result, 6);
	}

	@Test
	public void testAddMethodCounter() {
		assertEquals(addMethodCounter, 0);
	}

}
