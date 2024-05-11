package collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedCircularLinkedListTest {

	SortedCircularLinkedList<Integer> list;
	Object[] arr;

	@BeforeEach
	void beforeEach() {
		list = new SortedCircularLinkedList<Integer>();
	}

	@Test
	void testNoInsert() {
		arr = list.getAllElements();
		assertTrue(arr.length == 0);
	}

	@Test
	void testInsert() {
		list.insert(2);
		list.insert(4);
		list.insert(2);
		list.insert(6);
		list.insert(0);

		arr = list.getAllElements();
		assertTrue(arr[0].equals(0));
		assertTrue(arr[1].equals(2));
		assertTrue(arr[2].equals(2));
		assertTrue(arr[3].equals(4));
		assertTrue(arr[4].equals(6));
	}

}
