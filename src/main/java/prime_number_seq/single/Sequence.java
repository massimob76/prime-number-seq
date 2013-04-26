package prime_number_seq.single;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import prime_number_seq.Helper;


public class Sequence {
	
	public List<BigInteger> create(final int n) {
		List<BigInteger> seq = new ArrayList<BigInteger>();
		BigInteger num = BigInteger.ZERO;
		for (int i = 0; i < n; ) {
			num = num.add(BigInteger.ONE);
			if (Helper.isPrime(num)) {
				seq.add(num);
				i++;
			}
		}
		return seq;
	}

}
