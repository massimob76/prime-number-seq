package prime_number_seq.multi;

import static org.junit.Assert.assertEquals;
import static prime_number_seq.Helper.TWO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import prime_number_seq.multi.Sequence;

public class SequenceTest {
	
	@Test
	public void createSequenceOfOneElement() throws InterruptedException, ExecutionException {
		@SuppressWarnings("serial")
		List<BigInteger> expected = new ArrayList<BigInteger>() {{
			add(BigInteger.ONE);
		}};
		List<BigInteger> actual = new Sequence().create(1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void createSequenceOfTwoElements() throws InterruptedException, ExecutionException {
		@SuppressWarnings("serial")
		List<BigInteger> expected = new ArrayList<BigInteger>() {{
			add(BigInteger.ONE);
			add(TWO);
		}};
		List<BigInteger> actual = new Sequence().create(2);
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
		List<BigInteger> actual = new Sequence().create(5);
		assertEquals(expected, actual);
	}
	
	@Test
	public void createSequenceOf1000Elements() throws InterruptedException, ExecutionException {
		List<BigInteger> expected = new prime_number_seq.single.Sequence().create(1000);
		List<BigInteger> actual = new Sequence().create(1000);
		assertEquals(expected, actual);
	}

}
