package datastructures.computationalcomplexity;

public class ComputationalTimeComplexity {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// O(1), constant time
		long value = 42;
		
		//O(n * n) = O(n^2) = quadratic , e.g. bubble sort
		long time = System.nanoTime();
		try {
			String s ="";
			for(int i=0; i < 10_000; i++) {
				s +=i;
			}
		}finally {
			time = System.nanoTime() - time;
			System.out.printf("time = %dms%n",(time/1_000_000));
		}
		
		//O(n * n * n) = O(n^3) = cubic
		
		//O(log n) = logarithmic, e.g. binary search
		
		//O(n * log n) = quasilinear , e.g merge sort, parallel sort, sequential sort

	}

}
