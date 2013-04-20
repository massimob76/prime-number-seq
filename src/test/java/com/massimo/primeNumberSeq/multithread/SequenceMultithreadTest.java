package com.massimo.primeNumberSeq.multithread;

import static com.massimo.primeNumberSeq.Sequence.TWO;
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import com.massimo.primeNumberSeq.Sequence;

public class SequenceMultithreadTest {
	
	@Test
	public void createSequenceOfOneElement() throws InterruptedException, ExecutionException {
		@SuppressWarnings("serial")
		List<BigInteger> expected = new ArrayList<BigInteger>() {{
			add(BigInteger.ONE);
		}};
		List<BigInteger> actual = new SequenceMultithread().create(1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void createSequenceOfTwoElements() throws InterruptedException, ExecutionException {
		@SuppressWarnings("serial")
		List<BigInteger> expected = new ArrayList<BigInteger>() {{
			add(BigInteger.ONE);
			add(TWO);
		}};
		List<BigInteger> actual = new SequenceMultithread().create(2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void createSequenceOfFiveElements() throws InterruptedException, ExecutionException {
		@SuppressWarnings("serial")
		List<BigInteger> expected = new ArrayList<BigInteger>() {{
			add(BigInteger.ONE);
			add(TWO);
			add(BigInteger.valueOf(3L));
			add(BigInteger.valueOf(5L));
			add(BigInteger.valueOf(7L));
		}};
		List<BigInteger> actual = new SequenceMultithread().create(5);
		assertEquals(expected, actual);
	}
	
	@Test
	public void createSequenceOf1000Elements() throws InterruptedException, ExecutionException {
		List<BigInteger> expected = new Sequence().create(1000);
		List<BigInteger> actual = new SequenceMultithread().create(1000);
		assertEquals(expected, actual);
	}

}
