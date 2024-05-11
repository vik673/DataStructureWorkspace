package com.app.example2;

public interface IDoublyLinkedList {
	//Reverse Order
	int[] GetAllElementsInReverseOrder();
	
	void addAtFront(int elem);
	void addAtRear(int elem);
	void addAtPos(int elem, int pos);

	int[] getElementsInFowardDir();
	int[] getElementsInBackwardDir();
	
	int deleteFromFront();
	int deleteFromRear();
	int deleteFromPos(int pos);

}
