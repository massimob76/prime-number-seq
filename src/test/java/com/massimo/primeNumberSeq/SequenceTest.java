package com.massimo.primeNumberSeq;

import static org.junit.Assert.*;
import static com.massimo.primeNumberSeq.Sequence.TWO;
import static com.massimo.primeNumberSeq.Sequence.isPrime;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SequenceTest {
	
	@Test
	public void isPrimeShouldRecognizeOneAsPrimeNumber() {
		assertTrue(isPrime(BigInteger.ONE));
	}
	
	@Test
	public void isPrimeShouldRecognizeTwoAsPrimeNumber() {
		assertTrue(isPrime(TWO));
	}
	
	@Test
	public void isPrimeShouldRecognizeThreeAsPrimeNumber() {
		assertTrue(isPrime(BigInteger.valueOf(3L)));
	}
	
	@Test
	public void isPrimeShouldRecognizeFourNotAsPrimeNumber() {
		assertFalse(isPrime(BigInteger.valueOf(4L)));
	}
	
	@Test
	public void createSequenceOfOneElement() {
		@SuppressWarnings("serial")
		List<BigInteger> expected = new ArrayList<BigInteger>() {{
			add(BigInteger.ONE);
		}};
		List<BigInteger> actual = new Sequence().create(1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void createSequenceOfTwoElements() {
		@SuppressWarnings("serial")
		List<BigInteger> expected = new ArrayList<BigInteger>() {{
			add(BigInteger.ONE);
			add(TWO);
		}};
		List<BigInteger> actual = new Sequence().create(2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void createSequenceOfFiveElements() {
		@SuppressWarnings("serial")
		List<BigInteger> expected = new ArrayList<BigInteger>() {{
			add(BigInteger.ONE);
			add(TWO);
			add(BigInteger.valueOf(3L));
			add(BigInteger.valueOf(5L));
			add(BigInteger.valueOf(7L));
		}};
		List<BigInteger> actual = new Sequence().create(5);
		assertEquals(expected, actual);
	}

}
