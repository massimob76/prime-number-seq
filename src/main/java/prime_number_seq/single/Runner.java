package prime_number_seq.single;

import java.util.concurrent.ExecutionException;

import prime_number_seq.single.Sequence;


public class Runner {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		new Sequence().create(Integer.parseInt(args[0]));
	}

}
