package collections;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class QueueUsingStackTest {

	@Test
	void test1() {
		IQueue<Integer> q = new QueueUsingStack<>(5);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		assertTrue(q.remove()==1&&q.remove()==2&&q.remove()==3&&q.remove()==4&&q.remove()==5&&q.isEmpty());
		
	}
	
	@Test
	void test2() {
		IQueue<Integer> q = new QueueUsingStack<>(5);
		q.add(1);
		q.remove();
		boolean a = false;
		try {
			q.remove();
		}catch (Exception e) {
			a=true;
		}
		assertTrue(a);
	}

	
	@Test
	void test3() {
		IQueue<Integer> q = new QueueUsingStack<>(5);
		q.add(1);
		q.remove();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		
		boolean a = false;
		try {
			q.add(6);
		}catch (Exception e) {
			a=true;
		}
		assertTrue(a);
	}
	@Test
	void test4() {
		IQueue<Integer> q = new QueueUsingStack<>(5);
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
		IQueue<Integer> q = new QueueUsingStack<>(5);
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
