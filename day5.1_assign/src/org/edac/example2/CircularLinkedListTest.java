package org.edac.example2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircularLinkedListTest {

	@Test
	void insertOneElement() {
		CircularLinkedList clist = new CircularLinkedList();
		clist.Insert(10);
		assertTrue((clist.getCount() == 1) && (clist.GetAllElements()[0] == 10));
	}
	@Test
	void insertTwoElement() {
		CircularLinkedList clist = new CircularLinkedList();
		clist.Insert(10);
		clist.Insert(5);
		assertTrue((clist.getCount() == 2) && (clist.GetAllElements()[0] == 5) && (clist.GetAllElements()[1] == 10));
	}
	
	@Test
	void insertTwoElement2() {
		CircularLinkedList clist = new CircularLinkedList();
		clist.Insert(10);
		clist.Insert(20);
		assertTrue((clist.getCount() == 2) && (clist.GetAllElements()[0] == 10) && (clist.GetAllElements()[1] == 20));
	}

	@Test
	void insertThreeElement() {
		CircularLinkedList clist = new CircularLinkedList();
		clist.Insert(10);
		clist.Insert(20);
		clist.Insert(15);
		assertTrue((clist.getCount() == 3) && (clist.GetAllElements()[0] == 10) && (clist.GetAllElements()[1] == 15)&& (clist.GetAllElements()[2] == 20));
		

	}
}