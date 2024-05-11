package collections;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

	@Test
	void initialSize() {
		ILinkedList<Integer> list = new SinglyLinkedList<>();
		Object[] arr = list.getAllElements();
		assertTrue(arr.length==0);
	}
	
	@Test
	void testAddElementAtFront() {
		ILinkedList<Integer> list = new SinglyLinkedList<>();
		Integer element =2;
		list.addAtFront(element);
		assertTrue(list.getAllElements().length==1&&list.getAllElements()[0]==element);
	}
	
	@Test
	void testElementInBetween() {
		ILinkedList<Integer> list = new SinglyLinkedList<>();
		list.addAtFront(1);
		list.addAtFront(2);
		list.addAtFront(3);
		Object[] arr= list.getAllElements();
		assertTrue(arr[0].equals(3)&&arr[1].equals(2)&&arr[2].equals(1));
	}
	
	@Test
	void testElementAtRear() {
		ILinkedList<Integer> list = new SinglyLinkedList<>();
		list.addAtRear(3);
		list.addAtRear(2);
		list.addAtRear(1);
		Object[] arr= list.getAllElements();
		assertTrue(arr[0].equals(3)&&arr[1].equals(2)&&arr[2].equals(1));
	}
	
	
	@Test
	void testDeleteEmptyList() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		assertThrows(RuntimeException.class, ()->list.delete(5));
		
		}
	
	
	@Test
	void testDeleteFirstList() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.addAtFront(5);
		list.addAtFront(10);
		list.delete(10);
		Object[] arr = list.getAllElements();
		assertTrue(list.getNodeCount()==1);
		assertTrue(arr[0].equals(5));
		}
	

	@Test
	void testDeleteLastList() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.addAtFront(5);
		list.addAtFront(10);
		list.delete(5);
		Object[] arr = list.getAllElements();
		assertTrue(list.getNodeCount()==1);
		assertTrue(arr[0].equals(10));
		}
	
	@Test
	void testDeleteMidList() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.addAtFront(5);
		list.addAtFront(10);
		list.addAtFront(12);
		list.addAtFront(13);
		list.delete(10);
		Object[] arr = list.getAllElements();
		assertTrue(list.getNodeCount()==3);
		assertTrue(arr[0].equals(13));
		assertTrue(arr[1].equals(12));
		assertTrue(arr[2].equals(5));
		}

	@Test
	void testDeleteNonExistingList() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.addAtFront(5);
		list.addAtFront(12);
		list.addAtFront(13);
		list.delete(10);
		Object[] arr = list.getAllElements();
		assertTrue(list.getNodeCount()==3);
		assertTrue(arr[0].equals(13));
		assertTrue(arr[1].equals(12));
		assertTrue(arr[2].equals(5));
		}

}
