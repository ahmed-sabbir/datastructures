package datastructures.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class LargeListSorting {

	public static void main(String[] args) {
	
		// -verbose:gc
		// -verbose:gc -XX:+UnlockDiagnosticVMOptions
		// -verbose:gc -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC
		// Final:
		// VM arguments:
		// -verbose:gc -XX:+UseParallelGC -Xmx8g -Xms8g
		// Program arguments:
		// -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC
		List<Integer> numbers = ThreadLocalRandom.current().ints(20_000_000).boxed().collect(Collectors.toList());
		numbers.sort(null); // Will be even faster if its partially pre-sorted
		for(int i=0;i<10;i++) {
			test(numbers);
		}
	}

	private static void test(List<Integer> numberList) {
		List<Integer> numbers = new ArrayList<>(numberList);
		long time = System.nanoTime();
		try {
			numbers.sort(null);
		} finally {
			time = System.nanoTime() - time;
			System.out.printf("time = %dms%n", time / 1_000_000);
		}
	}

}
