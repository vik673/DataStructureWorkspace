package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.CircularQueueImpl;
import collections.IQueue;
import collections.QueueImpl;

class CircularImplTest {

	@Test
	void test1() {
		IQueue<Integer> cirQueue = new CircularQueueImpl<>(3);
		cirQueue.add(1);
		assertTrue(cirQueue.remove()==1);
	}
	
	@Test
	void test2() {
		IQueue<String> cirQueue = new CircularQueueImpl<>(3);
		cirQueue.add("vikas ji");
		assertTrue(cirQueue.remove()=="vikas ji");
	}
	
	@Test
	void test3() {
		IQueue<Integer> cirQueue = new CircularQueueImpl<>(3);
		cirQueue.add(1);
		cirQueue.add(2);
		cirQueue.add(3);
		assertTrue(cirQueue.remove()==1);
	}
}
