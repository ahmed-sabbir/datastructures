package datastructures.lists;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class COWList {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//Expensive if elements are frequently added or removed because of locking
		//Efficient if used for iterating frequently. 
		//Takes a snapshot of the collection when the iterator is created for iterating
		
		CopyOnWriteArrayList<String> names = new CopyOnWriteArrayList<>(); // COW's iterator is a snapshot iterator
		//List<String> names = Collections.synchronizedList(new ArrayList<>());
		//Collection<String> names= new ConcurrentLinkedQueue<>();
		names.add("Nanditha");
		names.add("Sorabh");
		Iterator<String> iterator = names.iterator();
		names.add("Heinz");
		
		// add vm argument '-verbose:gc' to see gc in action for making the list grow
		// '-verbose:gc -XX:+UseParallelGC' to see more stuff ... all to prove that adding/removing is very expensive for COW
		for(int i=0; i<100_000;i++) {
			names.add("Chuck");
		}
	}
}
