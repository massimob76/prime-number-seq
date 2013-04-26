package prime_number_seq.multi;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;

import prime_number_seq.multi.AtomicBigInteger;

public class AtomicBigIntegerTest {
	
	private AtomicBigInteger iut;
	
	@Before
	public void setUp() {
		iut = new AtomicBigInteger(BigInteger.ZERO);
	}
	
	@Test
	public void incrementAndGet() {
		assertEquals(BigInteger.ONE, iut.incrementAndGet());
	}
	
	@Test
	public void incrementAndGetInAMultithreadedEnv() throws InterruptedException, ExecutionException {

		final ConcurrentSkipListMap<BigInteger, Boolean> map = new ConcurrentSkipListMap<BigInteger, Boolean>();
		
		ExecutorService pool = Executors.newFixedThreadPool(100);
		
		Runnable runnable = new Runnable() {
			public void run() {
				map.put(iut.incrementAndGet(), Boolean.TRUE);
			}
		};
		
		List<Future<?>> futures = new LinkedList<Future<?>>();
		for (int i = 0; i < 1000; i++) {
			futures.add(pool.submit(runnable));
		}
		for (Future<?> future: futures) {
			future.get();
		}
		pool.shutdown();
		
		verifyResults(map);

	}
	
	@Test
	public void getAndIncrement() {
		assertEquals(BigInteger.ZERO, iut.getAndIncrement());
		assertEquals(BigInteger.ONE, iut.getAndIncrement());
	}
	
	@Test
	public void getAndIncrementInAMultithreadedEnv() throws InterruptedException, ExecutionException {
		
		iut.getAndIncrement();

		final ConcurrentSkipListMap<BigInteger, Boolean> map = new ConcurrentSkipListMap<BigInteger, Boolean>();
		
		ExecutorService pool = Executors.newFixedThreadPool(100);
		
		Runnable runnable = new Runnable() {
			public void run() {
				map.put(iut.getAndIncrement(), Boolean.TRUE);
			}
		};
		
		List<Future<?>> futures = new LinkedList<Future<?>>();
		for (int i = 0; i < 1000; i++) {
			futures.add(pool.submit(runnable));
		}
		for (Future<?> future: futures) {
			future.get();
		}
		pool.shutdown();
		
		verifyResults(map);

	}


	private void verifyResults(ConcurrentSkipListMap<BigInteger, Boolean> map) {
		int expected = 1;
		for (BigInteger bigInteger: map.keySet()) {
			assertEquals(expected++, bigInteger.intValue());
		}
		
	}

}
