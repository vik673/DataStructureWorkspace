package collections;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CircularQueueImpl2Test {

	@Test
	void test1() {
		IQueue<Integer> q = new CircularQueueImpl2<>(5);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		assertTrue(q.remove()==1&&q.remove()==2&&q.remove()==3&&q.remove()==4&&q.remove()==5&&q.isEmpty());
		
	}
	
	@Test
	void test2() {
		IQueue<Integer> q = new CircularQueueImpl2<>(5);
		q.add(1);
		q.remove();
		assertThrows(RuntimeException.class, q::remove);
	}

	
	@Test
	void test3() {
		IQueue<Integer> q = new CircularQueueImpl2<>(5);
		q.add(1);
		q.remove();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		assertThrows(RuntimeException.class, ()->q.add(6));
	}
	@Test
	void test4() {
		IQueue<Integer> q = new CircularQueueImpl2<>(5);
		q.add(1);
		q.remove();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		assertTrue(q.isFull());
	}
	
	@Test
	void test5() {
		IQueue<Integer> q = new CircularQueueImpl2<>(5);
		q.add(1); //1
		q.remove(); //
		q.add(1);  
		q.add(2);   //1 2
		q.remove(); //2
		q.add(3);   
		q.add(4);
		q.add(5);   //2 3 4 5
		q.remove(); //3 4 5
		q.remove();
		q.add(6);   // 4 5 6
		
		boolean a = q.remove()==4;
		assertTrue(a);
		
	}

}
