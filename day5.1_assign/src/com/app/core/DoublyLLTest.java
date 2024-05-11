package com.app.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoublyLLTest {

	@Test
	void testDeleteEleNotInList() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addAtFront(10);
		list.deleteElementUsingHead(100);
				
		int[] elems = list.getElementsInFowardDir();
		assertTrue(elems.length == 1);

		
	}
	@Test
	void testDeleteEleFrontList() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addAtFront(60);
		list.deleteElementUsingHead(60);
		
		int[] elems = list.getElementsInFowardDir();
		assertTrue(elems.length == 0);
	}

	@Test
	void testDeleteLastNodeList() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addAtRear(40);
		list.deleteElementUsingTail(40);
		
		int[] elems = list.getElementsInFowardDir();
		assertTrue(elems.length == 0);
	}
}
