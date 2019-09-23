package datastructures.mapsandsets;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.IntStream;

public class ParallelTreePut {

	public static void main(String[] args) {
		// Will work without any problem if accessed in parallel
		test(new ConcurrentSkipListMap<>());
		test(new Hashtable<>());
		test(new ConcurrentHashMap<>());
		
		// will not work consistently
		test(new HashMap<>());
		test(new TreeMap<>());
	}

	private static void test(Map<Integer, Integer> map) {
		System.out.println(map.getClass().getSimpleName());
		try {
			IntStream.range(0, 1_000_000)
						.parallel()
						.forEach(i -> map.put(i, i));
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("map.size()="+map.size());
		
	}

}
