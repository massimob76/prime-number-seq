package prime_number_seq.multi;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class AtomicBigInteger {
	
	private final AtomicReference<BigInteger> valueHolder = new AtomicReference<BigInteger>();
	
	public AtomicBigInteger(BigInteger bigInteger) {
		valueHolder.set(bigInteger);	
	}
	
	public BigInteger incrementAndGet() {
		while (true) {
			BigInteger current = valueHolder.get();
			BigInteger next = current.add(BigInteger.ONE);
			if (valueHolder.compareAndSet(current, next)) {
				return next;
			}
		}
	}
	
	public BigInteger getAndIncrement() {
		while (true) {
			BigInteger current = valueHolder.get();
			BigInteger next = current.add(BigInteger.ONE);
			if (valueHolder.compareAndSet(current, next)) {
				return current;
			}
		}
	}
}
