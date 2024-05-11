package org.edac.example1;

public interface IDoublyLinkedList {
	void addAtFront(int elem);
	void addAtRear(int elem);
	void addAtPos(int elem, int pos);

	int[] getElementsInFowardDir();
	int[] getElementsInBackwardDir();
	
	int deleteFromFront();
	int deleteFromRear();
	int deleteFromPos(int pos);
	
	void deleteElementUsingHead(int elem);
	void deleteElementUsingTail(int elem);

}
