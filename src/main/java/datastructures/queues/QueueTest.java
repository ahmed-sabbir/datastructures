package datastructures.queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class QueueTest {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//Most common type of queues
		Queue<Integer> qC = new ConcurrentLinkedQueue<>();
		Queue<Integer> qB = new LinkedBlockingQueue<>();
		
		Queue<?>[] nonthreadsafeQueue = {
				new ArrayDeque<>(), //Use ArrayDeque if you want a nonthreadsafe queue
				new LinkedList<>(),
				new PriorityQueue<>()
				// jctools has fast queues
		};
		
		Queue<?>[] threadsafeQueue = {
				new ConcurrentLinkedQueue<>()
		};
		
		Deque<?>[] threadsafeDeque = {
				new ConcurrentLinkedDeque<>()
		};
		
		BlockingQueue<?>[] threadsafeBlockingQueue = {
				new ArrayBlockingQueue<>(10),
				new DelayQueue<>(),
				new LinkedBlockingQueue<>(),
				new LinkedTransferQueue<>(),
				new PriorityBlockingQueue<>(),
				new SynchronousQueue<>()
		};
		
		BlockingDeque<?>[] threadsafeBlockingDeque = {
				new LinkedBlockingDeque<>()
		};
	}

}
