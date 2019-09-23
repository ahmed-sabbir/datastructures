package datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Properties;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Threadsafety {
	
	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		Collection<?>[] nonthreadsafe = {
				new ArrayDeque<>(),
				new ArrayList<>(),
				new HashSet<>(),
				new LinkedHashSet<>(),
				new LinkedList<>(),
				new PriorityQueue<>(),
				new TreeSet<>()
		};
		
		Collection<?>[] threadsafe = {
				new ArrayBlockingQueue<>(10),
				new ConcurrentLinkedQueue<>(),
				new ConcurrentLinkedDeque<>(),
				new ConcurrentSkipListSet<>(),
				new CopyOnWriteArrayList<>(),
				new DelayQueue<>(),
				new LinkedBlockingDeque<>(),
				new LinkedBlockingQueue<>(),
				new LinkedTransferQueue<>(),
				new PriorityBlockingQueue<>(),
				new Stack<>(),
				new SynchronousQueue<>(),
				new Vector<>(),
				Collections.synchronizedCollection(nonthreadsafe[0])
		};
		
		Map< ? , ? >[] nonThreadsafeMaps = {
				new HashMap<>(), //never use a hashmap, use ConcurrentHashMap instead of HashMap
				new EnumMap(Thread.State.class),
				new IdentityHashMap<>(),
				new LinkedHashMap<>(),
				new TreeMap<>(), // Do not use if accessed in parallel    	
				new WeakHashMap<>()
				
		};
		
		Map< ? , ? >[] threadsafeMaps = {
				new ConcurrentHashMap<>(), // use ConcurrentHashMap instead of HashMap, it is weakly consistent
				new ConcurrentSkipListMap<>(),
				new Hashtable<>(),
				new Properties()
		};
	}

}
