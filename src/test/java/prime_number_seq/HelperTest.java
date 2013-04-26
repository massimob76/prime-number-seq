package prime_number_seq;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static prime_number_seq.Helper.TWO;
import static prime_number_seq.Helper.isPrime;


import java.math.BigInteger;

import org.junit.Test;

public class HelperTest {
	
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

}
