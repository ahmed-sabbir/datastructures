package datastructures.mapsandsets;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class MapsAndSets {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Set<Integer> ts = new TreeSet<>(); // not threadsafe
		Set<Integer> csls = new ConcurrentSkipListSet<>(); // threadsafe
		
		Set<Integer> hs = new HashSet<>();
		Set<Integer> chs= Collections.newSetFromMap(new ConcurrentHashMap<>()); // Concurrent hashset
	}

}
