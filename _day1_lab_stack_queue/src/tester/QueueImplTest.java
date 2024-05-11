package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.IQueue;
import collections.IStack;
import collections.QueueImpl;
import collections.StackImpl;

class QueueImplTest {
	
	@Test
	void test1() {
		IQueue<Integer> queue = new QueueImpl<>(3);
		queue.add(1);
		assertTrue(queue.remove()==1);
	}
	
	@Test
	void test2() {
		IQueue<Integer> queue = new QueueImpl<>(3);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		assertTrue(queue.remove()==1);
	}
	
	@Test
	void test3(){
		IQueue<String> queue = new QueueImpl<>(3);
		queue.add("vikas ji");
		queue.add("jaiswal ji");
		queue.add("vikki");
		assertTrue(queue.remove()=="vikas ji");
	}
		@Test
		void test4() {
			IQueue<Double> queue = new QueueImpl<>(3);
			queue.add(4.4);
			queue.remove();
			queue.add(3.6);
			assertTrue(queue.peek()==3.6);
					
	}
}
