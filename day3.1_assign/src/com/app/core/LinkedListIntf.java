package com.app.core;

public interface LinkedListIntf {
	//append element at front in LL
	public void AddAtFront(int element);
	//append element at end in LL
	public void AddAtRear(int element);
	//append element at given position 
	public void AddAtPos(int element, int pos);
	//delete element from front
	public int DeleteFromFront();	
	//delete element from rear
	public int DeleteFromRear();	
	//delete element from given pos
	public int DeleteFromPos(int pos);

	public int deleteElement(int elem);

	//get data of each node connected in LL
	public int[] GetAllElements();
	
}
