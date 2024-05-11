package com.app.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortedLinkedListTest {

	@Test
	void sortedtest() {
		SortedLinkedList list = new SortedLinkedList();
		int ele1 = 2;
		int ele2 = 4;
		int ele3 = 1;
		int ele4 = 3;
		int ele5 = 5;
		
		list.Insert(ele1);
		list.Insert(ele2);
		list.Insert(ele3);
		list.Insert(ele4);
		list.Insert(ele5);

		assertEquals(list.GetAllElements()[0], ele3);
		assertEquals(list.GetAllElements()[1], ele1);
		assertEquals(list.GetAllElements()[2], ele4);
		assertEquals(list.GetAllElements()[3], ele2);
		assertEquals(list.GetAllElements()[4], ele5);

	}
}
