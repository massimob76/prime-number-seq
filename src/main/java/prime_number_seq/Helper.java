package prime_number_seq;

import java.math.BigInteger;

public class Helper {
	
	public static final BigInteger TWO = BigInteger.valueOf(2L);
	
	public static boolean isPrime(BigInteger num) {
		for (BigInteger i = TWO; i.compareTo(num) < 0; i = i.add(BigInteger.ONE)) {
			if (num.remainder(i).equals(BigInteger.ZERO)) {
				return false;
			}
		}
		return true;
	}

}
