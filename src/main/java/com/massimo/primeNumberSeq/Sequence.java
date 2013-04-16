package com.massimo.primeNumberSeq;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Sequence {
	
	public static final BigInteger TWO = BigInteger.valueOf(2L);
	
	public List<BigInteger> create(int n) {
		List<BigInteger> seq = new ArrayList<BigInteger>();
		BigInteger num = BigInteger.ZERO;
		for (int i = 0; i < n; ) {
			num = num.add(BigInteger.ONE);
			if (isPrime(num)) {
				seq.add(num);
				i++;
			}
		}
		return seq;
	}
	
	static boolean isPrime(BigInteger num) {
		for (BigInteger i = TWO; i.compareTo(num) < 0; i = i.add(BigInteger.ONE)) {
			if (num.remainder(i).equals(BigInteger.ZERO)) {
				return false;
			}
		}
		return true;
	}

}
