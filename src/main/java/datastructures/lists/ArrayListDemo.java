package datastructures.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ArrayListDemo {

	@SuppressWarnings({ "unused", "serial" })
	public static void main(String[] args) {
		
		var seasons = new LinkedList<String>();
		Collections.addAll(seasons, "summer", "spring", "winter", "fall");
		System.out.println(seasons);
		
		System.out.println("Adding snow");
		for(int i=0; i< 1_000_000; i++) {
			seasons.add("snow");
		}
		
		System.out.println("Deleting snow");
		Long time = System.nanoTime();
		try {
			seasons.removeIf(s -> s.equals("snow"));
			System.out.println(seasons);
		}finally {
			time = System.nanoTime() - time;
			System.out.printf("time = %dms%n",time/1_000_000);
		}
		
		//old way of looping
//		for (Iterator<String> it = seasons.iterator(); it.hasNext();) {
//			String season = it.next();
//			if(season.equals("snow")) it.remove();
//		}
		
		
		
		
		// Different ways of declaring ArrayLists
		var list1 = new ArrayList<String>();			// Java 10+
		List<String> list2 = new ArrayList<>();			// Java 7+
		List<String> list3 = new ArrayList<String>();	// Java 5+
		
		// Difference between list1 and list2 is that type of list1 is ArrayList, not List.
		// Thus only associated methods are available for the two types, e.g.
		
		list1.trimToSize();
		//list2.trimToSize();
		
		var list4 = new ArrayList<String>() {
			public void foo() {
				System.out.println("Hello world");
			}
		};
		list4.foo();
	
		
	}
}
