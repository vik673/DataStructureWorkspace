package com.app.example2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

	@Test
	void testGetAllElemInReverse() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addAtRear(10);
		list.addAtRear(20);
		list.addAtRear(30);
		list.addAtRear(40);
		
		assertTrue((list.GetAllElementsInReverseOrder()[0] == 40)
				&& (list.GetAllElementsInReverseOrder()[1] ==30)
				&& (list.GetAllElementsInReverseOrder()[2] == 20)
				&& (list.GetAllElementsInReverseOrder()[3] == 10));
	}
}
