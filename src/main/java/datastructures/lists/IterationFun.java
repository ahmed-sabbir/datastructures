package datastructures.lists;

import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class IterationFun {

	public static void main(String[] args) {
		
		var names = new CopyOnWriteArrayList<String>(); // CopyOnWriteArrayList not suitable for a large number of elements
		Collections.addAll(names, "Marc","Michael","Mohanraj");
		Iterator<String> it = names.iterator();
		while(it.hasNext()) {
			String name = it.next();
			if(name.equals("Michael")) {
				names.add(0, "Naveen");
			}
		}
		System.out.println(names);
	}

}
