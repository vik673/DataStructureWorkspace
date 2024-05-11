package collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestIntersectionInLL {

	SinglyLinkedList<Integer> list1;
	SinglyLinkedList<Integer> list2;

	@BeforeEach
	void setUp() throws Exception {
		list1 = new SinglyLinkedList<>();
		list2 = new SinglyLinkedList<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		list1 = null;
		list2 = null;
	}

	@Test
	void testIntersection() {
		list1.addAtFront(1);
		list1.addAtFront(10);
		list1.addAtFront(3);
		list1.addAtFront(4);

		list2.addAtFront(2);
		list2.addAtFront(7);
		list2.head.next.next = list1.head.next.next;
		assertTrue(list1.hasIntersection(list2));
	}

	@Test
	void testNotIntersection() {
		list1.addAtFront(1);
		list1.addAtFront(10);
		list1.addAtFront(3);
		list1.addAtFront(4);
		list2.addAtFront(2);
		list2.addAtFront(7);
		assertFalse(list1.hasIntersection(list2));
	}

}
