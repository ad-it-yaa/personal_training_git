package com.stackroute.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.stackroute.Palindrome;

public class PalindromeTest {

	private static Palindrome palindrome;

	@BeforeClass
	public static void setup() {
		// This methods runs, before running any one of the test case
		// This method is used to initialize the required variables
		palindrome = new Palindrome();
	}

	@AfterClass
	public static void teardown() {
		// This method runs, after running all the test cases
		// This method is used to clear the initialized variables
		palindrome = null;
	}

	@Test
	public void testPalindromeEven() {
		assertEquals(
				"Entered number is palindrom",
				true, palindrome.checkNoForPalindrome(1221));
	}

	@Test
	public void testNotPalindromeEven() {
		assertEquals(
				"Entered number is not a palindrom number",
				false, palindrome.checkNoForPalindrome(1234));
	}

	@Test
	public void testPalindromeOdd() {
		assertEquals(
				"Entered number is palindrom",
				true, palindrome.checkNoForPalindrome(12321));
	}
	
	@Test
	public void testNotPalindromeOdd() {
		assertEquals(
				"Entered number is not a palindrom number",
				false, palindrome.checkNoForPalindrome(12355));
	}
	
	@Test
	public void testSumEvenDigitsEven() {
		assertEquals(
				"Sum of all even digits are 24",
				24, palindrome.sumEvenDigits(18484));
	}

	@Test
	public void testSumEvenDigitsOdd() {
		assertEquals(
				"Sum of all even digits are 12",
				12, palindrome.sumEvenDigits(184));
	}

	@Test
	public void testSumEvenDigitsZero() {
		assertEquals(
				"Sum of all even digits are 24",
				24, palindrome.sumEvenDigits(184804));
	}

	@Test
	public void testcheckPalindromeAndSumEvenDigitsLess() {
		assertEquals(
				"1234321 is a palindrome but sum of even digits are less than 25",
				"1234321 is palindrome and the sum of all even digits is less than 25", palindrome.checkPalindromeAndSumEvenDigits(1234321));
	}

	@Test
	public void testcheckPalindromeAndSumEvenDigitsMore() {
		assertEquals(
				"188881 is a palindrome but sum of even digits are more than 25",
				"188881 is palindrome and the sum of all even digits is greater than 25", palindrome.checkPalindromeAndSumEvenDigits(188881));
	}

	@Test
	public void testcheckPalindromeAndSumEvenDigitsNot() {
		assertEquals(
				"1281 is not a palindrome number",
				"1281 is not palindrome", palindrome.checkPalindromeAndSumEvenDigits(1281));
	}

}
