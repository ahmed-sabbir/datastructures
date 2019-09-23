package datastructures.sorting;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class LargeSorting {

	public static void main(String[] args) {
	
		// -verbose:gc
		// -verbose:gc -XX:+UnlockDiagnosticVMOptions
		// -verbose:gc -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC
		// Final:
		// VM arguments:
		// -verbose:gc -XX:+UseParallelGC -Xmx8g -Xms8g
		// Program arguments:
		// -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC
		int[] numbers = ThreadLocalRandom.current().ints(20_000_000).toArray();
		for(int i=0;i<10;i++) {
			test(numbers);
		}
	}

	private static void test(int[] numberArray) {
		int[] numbers = numberArray.clone();
		long time = System.nanoTime();
		try {
			Arrays.parallelSort(numbers);
		} finally {
			time = System.nanoTime() - time;
			System.out.printf("time = %dms%n", time / 1_000_000);
		}
	}

}
