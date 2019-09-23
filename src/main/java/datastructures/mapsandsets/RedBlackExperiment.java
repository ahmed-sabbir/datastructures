package datastructures.mapsandsets;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.LongAccumulator;

public class RedBlackExperiment {
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i< 1_000_000;i++) {
			list.add(i);
		}
		
		Collections.shuffle(list);
		
		for( Integer i : list) {
			map.put(i, i);
		}
		
		System.out.println("map.size()="+map.size());
		
		LongAccumulator min = new LongAccumulator(Long::min, Long.MAX_VALUE);
		LongAccumulator max = new LongAccumulator(Long::max, 0);
		Field parent = null;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(parent == null) {
				parent = entry.getClass().getDeclaredField("parent");
				parent.setAccessible(true);
			}
			int depth = bubbleup(entry,parent);
			min.accumulate(depth);
			max.accumulate(depth);
		}

		System.out.println("min:"+min);
		System.out.println("max:"+max);
	}

	private static int bubbleup(Object entry, Field parent) throws IllegalArgumentException, IllegalAccessException {
		if (entry == null) return 0;
		return 1  + bubbleup(parent.get(entry), parent);
	}

}
