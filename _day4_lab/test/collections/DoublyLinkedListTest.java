package collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {
	DoublyLinkedList<Integer> list;

	@BeforeEach
	void initList() {
		list = new DoublyLinkedList<>();

	}

	@Test
	void initialSize() {
		Object[] arr = list.getAllElements();
		assertTrue(arr.length == 0);
	}

	@Test
	void testAddElementAtFront() {

		Integer element = 2;
		list.addAtFront(element);
		assertTrue(list.getAllElements().length == 1 && list.getAllElements()[0] == element);
	}

	@Test
	void testElementInBetween() {

		list.addAtFront(1);
		list.addAtFront(2);
		list.addAtFront(3);
		Object[] arr = list.getAllElements();
		assertTrue(arr[0].equals(3) && arr[1].equals(2) && arr[2].equals(1));
	}

	@Test
	void testElementAtRear() {

		list.addAtRear(3);
		list.addAtRear(2);
		list.addAtRear(1);
		Object[] arr = list.getAllElements();
		assertTrue(arr[0].equals(3) && arr[1].equals(2) && arr[2].equals(1));
	}

	@Test
	void testDeleteEmptyList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		assertThrows(RuntimeException.class, () -> list.delete(5));

	}

	@Test
	void testDeleteFirstList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addAtFront(5);
		list.addAtFront(10);
		list.delete(10);
		Object[] arr = list.getAllElements();
		assertTrue(list.getNodeCount() == 1);
		assertTrue(arr[0].equals(5));
	}

	@Test
	void testDeleteLastList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addAtFront(5);
		list.addAtFront(10);
		list.delete(5);
		Object[] arr = list.getAllElements();
		assertTrue(list.getNodeCount() == 1);
		assertTrue(arr[0].equals(10));
	}

	@Test
	void testDeleteMidList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addAtFront(5);
		list.addAtFront(10);
		list.addAtFront(12);
		list.addAtFront(13);
		list.delete(10);
		Object[] arr = list.getAllElements();
		assertTrue(list.getNodeCount() == 3);
		assertTrue(arr[0].equals(13));
		assertTrue(arr[1].equals(12));
		assertTrue(arr[2].equals(5));
	}

	@Test
	void testDeleteNonExistingList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addAtFront(5);
		list.addAtFront(12);
		list.addAtFront(13);
		list.delete(10);
		Object[] arr = list.getAllElements();
		assertTrue(list.getNodeCount() == 3);
		assertTrue(arr[0].equals(13));
		assertTrue(arr[1].equals(12));
		assertTrue(arr[2].equals(5));
	}

	@Test
	void testDeleteUsingTailEmptyList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		assertThrows(RuntimeException.class, () -> list.deleteUsingTail(5));

	}

	@Test
	void testdeleteUsingTailFirstList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addAtFront(5);
		list.addAtFront(10);
		list.deleteUsingTail(10);
		Object[] arr = list.getAllElements();
		assertTrue(list.getNodeCount() == 1);
		assertTrue(arr[0].equals(5));
	}

	@Test
	void testdeleteUsingTailLastList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addAtFront(5);
		list.addAtFront(10);
		list.deleteUsingTail(5);
		Object[] arr = list.getAllElements();
		assertTrue(list.getNodeCount() == 1);
		assertTrue(arr[0].equals(10));
	}

	@Test
	void testdeleteUsingTailMidList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addAtFront(5);
		list.addAtFront(10);
		list.addAtFront(12);
		list.addAtFront(13);
		list.deleteUsingTail(10);
		Object[] arr = list.getAllElements();
		assertTrue(list.getNodeCount() == 3);
		assertTrue(arr[0].equals(13));
		assertTrue(arr[1].equals(12));
		assertTrue(arr[2].equals(5));
	}

	@Test
	void testdeleteUsingTailNonExistingList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addAtFront(5);
		list.addAtFront(12);
		list.addAtFront(13);
		list.deleteUsingTail(10);
		Object[] arr = list.getAllElements();
		assertTrue(list.getNodeCount() == 3);
		assertTrue(arr[0].equals(13));
		assertTrue(arr[1].equals(12));
		assertTrue(arr[2].equals(5));
	}

	@Test
	void testRemoveFrontList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addAtFront(5);
		list.addAtFront(12);
		list.addAtFront(13);
		Integer a = list.removeAtFront();
		Object[] arr = list.getAllElements();
		assertEquals(a, 13);
		assertTrue(list.getNodeCount() == 2);
		assertTrue(arr[0].equals(12));
		assertTrue(arr[1].equals(5));
	}

	@Test
	void testRemoveRearList() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addAtFront(5);
		list.addAtFront(12);
		list.addAtFront(13);
		Integer a = list.removeAtRear();
		Object[] arr = list.getAllElements();
		assertEquals(a, 5);
		assertTrue(list.getNodeCount() == 2);
		assertTrue(arr[0].equals(13));
		assertTrue(arr[1].equals(12));
	}

	@Test
	void testCountFrequency() {
		list.addAtFront(5);
		list.addAtFront(1);
		list.addAtFront(13);
		list.addAtRear(5);
		list.addAtRear(12);
		list.addAtRear(13);
		list.addAtFront(5);
		list.addAtFront(12);
		list.addAtFront(13);
		list.addAtRear(5);
		int count = list.countFrequency(5);
		assertEquals(4, count);
		count = list.countFrequency(13);
		assertEquals(3, count);
		count = list.countFrequency(1);
		assertEquals(1, count);
		count = list.countFrequency(100);
		assertEquals(0, count);
	}
	
	@Test
	void testDeleteAll() {
		list.addAtFront(5);
		list.addAtFront(1);
		list.addAtFront(13);
		list.addAtRear(5);
		list.addAtRear(12);
		list.addAtRear(13);
		list.addAtFront(5);
		list.addAtFront(12);
		list.addAtFront(13);
		list.addAtRear(5);
		list.deleteAll(5);
		int count = list.countFrequency(5);
		assertEquals(0, count);
		count = list.countFrequency(13);
		assertEquals(3, count);
		count = list.countFrequency(1);
		assertEquals(1, count);
		count = list.countFrequency(100);
		assertEquals(0, count);
	}
	@Test
	void testDeleteAll2() {
		list.addAtFront(5);
		list.addAtFront(1);
		list.addAtFront(13);
		list.addAtRear(5);
		list.addAtRear(12);
		list.addAtRear(13);
		list.addAtFront(5);
		list.addAtFront(12);
		list.addAtFront(13);
		list.addAtRear(5);
		list.deleteAll(5);
		list.deleteAll(1);
		list.deleteAll(13);
		list.deleteAll(12);
		assertThrows(RuntimeException.class, ()->list.delete(1));
	}
	


}
