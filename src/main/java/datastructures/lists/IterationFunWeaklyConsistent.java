package datastructures.lists;

import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

public class IterationFunWeaklyConsistent {

	public static void main(String[] args) {
		
		// Weakly consistent is when any change made after the iterator has been created may or may not be visible, iterator might not show the element twice
		// if it is in the collection twice, it might skip over elements
		
		var names = new ConcurrentLinkedDeque<String>(); // CopyOnWriteArrayList not suitable for a large number of elements
		names.add("Sanjeev"); // 3. Add before iterator creation will make it work
		Iterator<String> it = names.iterator();   // 1. Create the iterator first
		it.next(); // 4. this will make it not work again - but no exception will be thrown
		Collections.addAll(names, "Marc","Michael","Mohanraj");  // 2. The iterator might or might show or delete the elements added or deleted after it was constructed
		while(it.hasNext()) {
			String name = it.next();
			if(name.equals("Michael")) {
				names.addFirst("Naveen");
			}
		}
		System.out.println(names);
	}

}
