package com.app.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

	@Test
	void testEmptyList() {
		SinglyLinkedList slist = new SinglyLinkedList();
		int[] listElements = slist.GetAllElements();
		assertTrue(listElements.length == 0);
	}
	
	@Test
	void testAddAtFrontOneElement() {
		SinglyLinkedList slist = new SinglyLinkedList();
		int element = 5;

		slist.AddAtFront(element);

		int[] listElements = slist.GetAllElements();

		assertTrue((listElements.length == 1) && (listElements[0] == element));
	}
	@Test
	void testAddAtFrontTwoElement() {
		SinglyLinkedList slist = new SinglyLinkedList();
		int element1 = 5;
		int element2 = 10;

		slist.AddAtFront(element1); // head -> 5
		slist.AddAtFront(element2); // head -> 10 -> 5

		int[] listElements = slist.GetAllElements(); // 10, 5

		assertTrue((listElements.length == 2) &&
				(listElements[0] == element2) && (listElements[1] == element1));
	}

	@Test
	void testAddAtRearOneElement() {
		SinglyLinkedList slist = new SinglyLinkedList();
		int element = 5;

		slist.AddAtRear(element);

		int[] listElements = slist.GetAllElements();

		assertTrue((listElements.length == 1) && (listElements[0] == element));
	}
	
	@Test
	void testAddAtRearTwoElement() {
		SinglyLinkedList slist = new SinglyLinkedList();
		int element1 = 5;
		int element2 = 10;

		slist.AddAtRear(element1); // head -> 5
		slist.AddAtRear(element2); // head -> 5-> 10

		int[] listElements = slist.GetAllElements(); // 10, 5

		assertTrue((listElements.length == 2) &&
				(listElements[0] == element1) && (listElements[1] == element2));
	}

	@Test
	void testAddAtPosFiveElement() {
		SinglyLinkedList slist = new SinglyLinkedList();
		int element1 = 3;
		int element2 = 1;
		int element3 = 2;
		int element4 = 4;

		slist.AddAtPos(element1, 1); 
		assertThrows(RuntimeException.class, () -> {
			slist.AddAtPos(7, 3);
		});
		
		slist.AddAtPos(element2, 1); 
		slist.AddAtPos(element3, 2); // head -> 5-> 10
		slist.AddAtPos(element4, 4); // head -> 5-> 10


		int[] listElements = slist.GetAllElements(); // 10, 5

		assertTrue((listElements.length == 4) &&
				(listElements[0] == element2) && (listElements[1] == element3) && (listElements[2] == element1) && (listElements[3] == element4));
	}

	@Test
	void testDeleteFromFrontElement() {
		SinglyLinkedList slist = new SinglyLinkedList();
		int element1 = 100;
		int element2 = 200;

		assertThrows(RuntimeException.class, () -> {
			slist.DeleteFromFront(); 
		});
		
		slist.AddAtPos(element1, 1); 
		slist.AddAtPos(element2, 2); 

		assertTrue(slist.DeleteFromFront() ==  100);
		assertTrue(slist.DeleteFromFront() ==  200);
	}

	@Test
	void testDeleteFromRearElement() {
		SinglyLinkedList slist = new SinglyLinkedList();
		int element1 = 100;
		int element2 = 200;

		assertThrows(RuntimeException.class, () -> {
			slist.DeleteFromRear(); 
		});
		
		slist.AddAtPos(element1, 1); 
		assertTrue(slist.DeleteFromRear() ==  100);

		slist.AddAtPos(element1, 1); 
		slist.AddAtPos(element2, 2); 

		assertTrue(slist.DeleteFromRear() ==  200);
		assertTrue(slist.DeleteFromRear() ==  100);
	}

	@Test
	void testDeleteFromPosFiveElement() {
		SinglyLinkedList slist = new SinglyLinkedList();
		int element1 = 1;
		int element2 = 2;
		int element3 = 3;
		int element4 = 4;

		assertThrows(RuntimeException.class, () -> {
			slist.DeleteFromPos(1);
		});

		assertThrows(RuntimeException.class, () -> {
			slist.DeleteFromPos(5);
		});

		slist.AddAtPos(element1, 1); 
		assertThrows(RuntimeException.class, () -> {
			slist.DeleteFromPos(2);
		});

		assertTrue(slist.DeleteFromPos(1) == 1);
		
		slist.AddAtPos(element1, 1); 
		slist.AddAtPos(element2, 2); 
		assertTrue(slist.DeleteFromPos(2) == 2);
	
		slist.AddAtPos(element2, 2); 
		slist.AddAtPos(element3, 3); 
		slist.AddAtPos(element4, 4); 
		assertTrue(slist.DeleteFromPos(3) == 3);

		}
	@Test
	void testDeleteElement1() {
		SinglyLinkedList slist = new SinglyLinkedList();
		int element1 = 10;
		int element2 = 20;

		assertThrows(RuntimeException.class, () -> {
			slist.deleteElement(100);
		});

		slist.AddAtPos(element1, 1); 
		assertTrue(slist.deleteElement(10) == 10);

	}
	
	@Test
	void testDeleteElement2() {
		SinglyLinkedList slist = new SinglyLinkedList();
		int element1 = 10;
		int element2 = 20;

		slist.AddAtPos(element1, 1); 
		slist.AddAtPos(element2, 2); 
		
		assertTrue((slist.deleteElement(10) == 10) &&
				(slist.deleteElement(20) == 20));
	}

	@Test
	void testDeleteElement22() {
		SinglyLinkedList slist = new SinglyLinkedList();
		int element1 = 10;
		int element2 = 20;
		int element3 = 30;
		int element4 = 40;

		slist.AddAtPos(element1, 1); 
		slist.AddAtPos(element2, 2); 
		slist.AddAtPos(element3, 3); 
		slist.AddAtPos(element4, 4); 

		assertTrue(slist.tail.data == 40);
		assertTrue((slist.deleteElement(30) == 30) &&
				(slist.deleteElement(40) == 40) &&
				(slist.deleteElement(20) == 20) &&
				(slist.deleteElement(10) == 10));
		
		
	}
	@Test
	void testDeleteElement3() {
		SinglyLinkedList slist = new SinglyLinkedList();
		int element1 = 10;
		int element2 = 20;
		int element3 = 30;
		int element4 = 40;

		slist.AddAtPos(element1, 1); 
		slist.AddAtPos(element2, 2); 
		slist.AddAtPos(element3, 3); 
		slist.AddAtPos(element4, 4); 

		assertTrue(slist.tail.data == 40);
		assertTrue((slist.deleteElement(30) == 30));
		assertTrue(slist.tail.data == 40);

		assertTrue((slist.deleteElement(40) == 40));
		assertTrue(slist.tail.data == 20);

		assertTrue((slist.deleteElement(20) == 20));
		assertTrue(slist.tail.data == 10);

		assertTrue((slist.deleteElement(10) == 10));
		
		
	}

}
