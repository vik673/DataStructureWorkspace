package com.app.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

	@Test
	void testGetAllElem() {
		DoublyLinkedList list = new DoublyLinkedList();
		assertEquals(0, list.getCount());
	}
	@Test
	void testInsertAtFront() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addAtFront(10);
		assertEquals(10, list.getElementsInFowardDir()[0]);
		assertEquals(10, list.getElementsInBackwardDir()[0]);

		list.addAtFront(20);
		assertEquals(20, list.getElementsInFowardDir()[0]);
		assertEquals(10, list.getElementsInFowardDir()[1]);

		assertEquals(10, list.getElementsInBackwardDir()[0]);
		

	}
	@Test
	void testInsertAtRear() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addAtRear(10);
		assertEquals(10, list.getElementsInFowardDir()[0]);
		assertEquals(10, list.getElementsInBackwardDir()[0]);

		list.addAtRear(20);
		assertEquals(10, list.getElementsInFowardDir()[0]);
		assertEquals(20, list.getElementsInFowardDir()[1]);

		assertEquals(20, list.getElementsInBackwardDir()[0]);
		

	}
	
	@Test
	void testInsertAtPos() {
		DoublyLinkedList list = new DoublyLinkedList();
		assertThrows(RuntimeException.class, ()-> {
			list.addAtPos(10, 2);
		});
		list.addAtPos(10, 1);
		list.addAtPos(30, 2);
		list.addAtPos(20, 2);
		list.addAtPos(50, 4);
		list.addAtPos(40, 4);
		
		assertEquals(10, list.getElementsInFowardDir()[0]);
		assertEquals(20, list.getElementsInFowardDir()[1]);
		assertEquals(30, list.getElementsInFowardDir()[2]);
		assertEquals(40, list.getElementsInFowardDir()[3]);
		assertEquals(50, list.getElementsInFowardDir()[4]);
//
//		list.addAtRear(20);
//		assertEquals(10, list.getElementsInFowardDir()[0]);
//		assertEquals(20, list.getElementsInFowardDir()[1]);
//
//		assertEquals(20, list.getElementsInBackwardDir()[0]);
	
	}

}
