package datastructures.computationalcomplexity;

import java.util.LinkedList;

public class ComputationalSpaceComplexity {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// 4 * 1_000_000 + 12(actual object) + 4 (length of object) = 4_000_016
		int[] i = new int[1_000_000];
				
		// 16 * 1_000_000 (integer objects) + (24 * 1_000_000) (nodes for each element) + (12 + 16 + 4 ) (member variables of LL + overhead)
		LinkedList<Integer> li = new LinkedList<Integer>();
	}

}
