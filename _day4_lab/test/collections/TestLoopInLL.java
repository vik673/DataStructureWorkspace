package collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestLoopInLL {

	SinglyLinkedList<Integer> list;

	@BeforeEach
	void setUp() throws Exception {
		list = new SinglyLinkedList<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	@Test
	void testLoopInLL() {
		list.addAtFront(5);
		list.addAtFront(4);
		list.addAtFront(1);
		list.addAtFront(2);
		SinglyListNode<Integer> a = list.head.next;
		list.head.next.next.next.next = a;
		assertTrue(list.hasLoop());

	}

	@Test
	void testLoopInLL2() {
		list.addAtFront(5);
		list.addAtFront(4);
		list.addAtFront(1);
		list.addAtFront(2);
		list.head.next.next.next.next = list.head;
		assertTrue(list.hasLoop());

	}

	@Test
	void testNotLoopInLL() {
		list.addAtFront(5);
		list.addAtFront(4);
		list.addAtFront(1);
		list.addAtFront(2);
		assertFalse(list.hasLoop());

	}
	
	
	
	@Test
	void testLoopInLLUsingSet() {
		list.addAtFront(5);
		list.addAtFront(4);
		list.addAtFront(1);
		list.addAtFront(2);
		SinglyListNode<Integer> a = list.head.next;
		list.head.next.next.next.next = a;
		assertTrue(list.hasLoopUsingHashSet());

	}

	@Test
	void testLoopInLLUsingSet2() {
		list.addAtFront(5);
		list.addAtFront(4);
		list.addAtFront(1);
		list.addAtFront(2);
		list.head.next.next.next.next = list.head;
		assertTrue(list.hasLoopUsingHashSet());

	}

	@Test
	void testNotLoopInLLUsingSet() {
		list.addAtFront(5);
		list.addAtFront(4);
		list.addAtFront(1);
		list.addAtFront(2);
		assertFalse(list.hasLoopUsingHashSet());

	}

}
