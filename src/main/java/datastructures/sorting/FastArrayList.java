package datastructures.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;

@SuppressWarnings("serial")
public class FastArrayList<E> extends ArrayList<E> {

	public FastArrayList() {
		// TODO Auto-generated constructor stub
	}

	public FastArrayList(Collection<? extends E> c) {
		super(c);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sort(Comparator<? super E> c) {
		if (c == null)
            c = NaturalOrder.INSTANCE;
		E last = null;
		boolean sorted = true;
		for(E e: this) {
			if(last !=null) {
				if(c.compare(last, e)>0) {
					sorted = false;
					break;
				}
			}
			last = e;
		};
		if (sorted) return;
		Object[] a = this.toArray();
		Arrays.parallelSort(a, (Comparator) c); // This is what we changed from the original function
		ListIterator<E> i = this.listIterator();
		for (Object e : a) {
			i.next();
			i.set((E) e);
		}
	}
	
	static final class NaturalOrder implements Comparator<Object> {
        @SuppressWarnings("unchecked")
        public int compare(Object first, Object second) {
            return ((Comparable<Object>)first).compareTo(second);
        }
        static final NaturalOrder INSTANCE = new NaturalOrder();
    }

}
