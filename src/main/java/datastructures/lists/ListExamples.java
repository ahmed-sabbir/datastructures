package datastructures.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListExamples {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//node based list, uses tons of memory
		LinkedList<Integer> ll = new LinkedList<Integer>(); // not threadsafe
		
		//based on array
		List<Integer> al = new ArrayList<Integer>(); // not threadsafe
		List<Integer> cowal = new CopyOnWriteArrayList<>(); // threadsafe
		List<Integer> v = new Vector<>(); // threadsafe
		
		Collection<Integer> cl= new ConcurrentLinkedQueue<Integer>(); //threadsafe, not fail fast, it's weakly consistent
		
		List<Integer> all = Arrays.asList(1,2,3);
		all.set(0, 4); // proves that Arrays.asList doesn't return an immutable list
		System.out.println("all:"+all);
		
		List<Integer> immutable = List.of(1,2,3);
		//immutable.add(4);
		//immutable.set(0, 4);
		
		al.addAll(immutable);
		List<Integer> notReallyUnmodifiable = Collections.unmodifiableList(al);
		System.out.println("notReallyUnmodifiable:"+ notReallyUnmodifiable);
		
		al.add(4);
		System.out.println("notReallyUnmodifiable:"+ notReallyUnmodifiable);
	}

}
