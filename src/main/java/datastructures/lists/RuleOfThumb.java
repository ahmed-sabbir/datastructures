package datastructures.lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RuleOfThumb {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// Always use:
		List<String> list = new ArrayList<>(); //not threadsafe
		
		//if you need thread-safety: 
		List<String> threadsafeList = Collections.synchronizedList(new ArrayList<>()); // threadsafe, it doesn't have fail-safe iteration, not failfast probably
		Collection<Integer> cl= new ConcurrentLinkedQueue<Integer>(); //threadsafe, not fail fast, it's weakly consistent, it is not a list - but can be treat as if was
		
		// No need to use LinkedList
		
	}

}
