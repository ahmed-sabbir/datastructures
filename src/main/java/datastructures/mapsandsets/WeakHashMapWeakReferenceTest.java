package datastructures.mapsandsets;

import java.lang.ref.WeakReference;

public class WeakHashMapWeakReferenceTest {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// WeakHashMap: uses weak references to make the entries disappear if the keys have disappeared or garbage collected. 
		
		Object o = new Object();
		System.out.println("o: " + o);
		
		WeakReference<?> ref = new WeakReference<>(o);
		System.out.println("ref: " + ref.get());
		
		o = null;
		
		for (int i=0;i<100000;i++) {
			byte[] junk = new byte[1000];
		}
		
		System.out.println("ref: " + ref.get());
		
	}

}
