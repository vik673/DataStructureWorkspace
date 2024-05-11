package collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedSinglyLinkedListTest {

	SortedSinglyLinkedList<Integer> list;
	Object[] arr;
	
	@BeforeEach
	void beforeEach() {
		list = new SortedSinglyLinkedList<Integer>();
	}

	@Test
	void testNoInsert() {
		arr = list.getAllElements();
		assertTrue(arr.length==0);
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
	
	

	@Test
	void testNoinsertUsingCur() {
		arr = list.getAllElements();
		assertTrue(arr.length==0);
	}
	
	@Test
	void testinsertUsingCur() {
		list.insertUsingCur(2);
		list.insertUsingCur(4);
		list.insertUsingCur(2);
		list.insertUsingCur(6);
		list.insertUsingCur(0);
		
		arr = list.getAllElements();
		assertTrue(arr[0].equals(0));
		assertTrue(arr[1].equals(2));
		assertTrue(arr[2].equals(2));
		assertTrue(arr[3].equals(4));
		assertTrue(arr[4].equals(6));
	}
	
	
	@Test
	void testMerge() {
		
		
		
		SortedSinglyLinkedList<Integer> list1 =  new SortedSinglyLinkedList<>();
		list1 .insert(1);
		list1 .insert(1);
		list1.insert(2);
		list1.insert(3);
		list1.insert(5);
		list1.insert(5);
		
		SortedSinglyLinkedList<Integer> list2 =  new SortedSinglyLinkedList<>();
		list2.insert(2);
		list2.insert(2);
		list2.insert(3);
		list2.insert(6);
		list2.insert(7);
		list2.insert(7);
		
		list = SortedSinglyLinkedList.merge(list1, list2);
		
		arr = list.getAllElements();
		assertTrue(arr[0].equals(1));
		assertTrue(arr[1].equals(1));
		assertTrue(arr[2].equals(2));
		assertTrue(arr[3].equals(2));
		assertTrue(arr[4].equals(2));
		assertTrue(arr[5].equals(3));
		assertTrue(arr[6].equals(3));
		assertTrue(arr[7].equals(5));
		assertTrue(arr[8].equals(5));
		assertTrue(arr[9].equals(6));
		assertTrue(arr[10].equals(7));
		assertTrue(arr[11].equals(7));
		
	}
	
	@Test
	void testMerge2() {
		
		
		
		SortedSinglyLinkedList<Integer> list1 =  new SortedSinglyLinkedList<>();
		list1 .insert(1);
		
		SortedSinglyLinkedList<Integer> list2 =  new SortedSinglyLinkedList<>();
		
		list = SortedSinglyLinkedList.merge(list1, list2);
		
		arr = list.getAllElements();
		assertTrue(arr[0].equals(1));
		assertEquals(1, arr.length);
		
	}
	
	
	@Test
	void testMerge3() {
		
		
		
		SortedSinglyLinkedList<Integer> list2 =  new SortedSinglyLinkedList<>();
		list2 .insert(1);
		
		SortedSinglyLinkedList<Integer> list1 =  new SortedSinglyLinkedList<>();
		
		list = SortedSinglyLinkedList.merge(list1, list2);
		
		arr = list.getAllElements();
		assertTrue(arr[0].equals(1));
		assertEquals(1, arr.length);
		
	}
	
	
	@Test
	void testMerge4() {
		
		
		
		SortedSinglyLinkedList<Integer> list2 =  new SortedSinglyLinkedList<>();
		
		SortedSinglyLinkedList<Integer> list1 =  new SortedSinglyLinkedList<>();
		
		list = SortedSinglyLinkedList.merge(list1, list2);
		
		arr = list.getAllElements();
		assertEquals(0, arr.length);
		
	}

}
