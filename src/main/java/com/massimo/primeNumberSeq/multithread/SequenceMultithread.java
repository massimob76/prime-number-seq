package com.massimo.primeNumberSeq.multithread;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import com.massimo.primeNumberSeq.Sequence;

public class SequenceMultithread {
	
	private final AtomicBigInteger num = new AtomicBigInteger(BigInteger.ONE);
	private final AtomicInteger index = new AtomicInteger(0);
	private final ConcurrentSkipListSet<BigInteger> seq = new ConcurrentSkipListSet<BigInteger>();
	
	private static final int NO_OF_THREADS = 4;

	
	public List<BigInteger> create(final int n) throws InterruptedException, ExecutionException {
		
		Runnable runnable = new Runnable() {
			
			public void run() {
				int currentIndex = index.getAndIncrement();
				while (currentIndex < n) {
					BigInteger candidate = num.getAndIncrement();
					if (Sequence.isPrime(candidate)) {
						currentIndex = index.getAndIncrement();
						seq.add(candidate);
					}
				}
			}
			
		};
		
		submitAndWaitForResults(runnable);
		
		return new ArrayList<BigInteger>(seq);
	}


	private void submitAndWaitForResults(Runnable runnable) throws InterruptedException, ExecutionException {
		
		ExecutorService pool = Executors.newFixedThreadPool(NO_OF_THREADS);
		List<Future<?>> futures = new ArrayList<Future<?>>();

		for (int i = 0; i < NO_OF_THREADS; i++) {
			futures.add(pool.submit(runnable));
		}
		
		for (Future<?> future: futures) {
			future.get();
		}
		
		pool.shutdown();
	}

}
