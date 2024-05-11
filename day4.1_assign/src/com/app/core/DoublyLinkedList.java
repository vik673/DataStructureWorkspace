package com.app.core;


public class DoublyLinkedList implements IDoublyLinkedList{
	private Node head, tail;
	
	public DoublyLinkedList() {
		head = tail = null;
	}
	@Override
	public void addAtFront(int elem) {
		Node newNode = new Node(elem);
		if(head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}
	@Override
	public void addAtRear(int elem) {
		Node newNode = new Node(elem);
		if(head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
	}
	@Override
	public void addAtPos(int elem, int pos) {
		if(getCount() == 0 && pos == 1) {
			addAtFront(elem);
			return;
		}
		if(pos == 1) {
			addAtFront(elem);
		}else if(pos == getCount() + 1) {
			addAtRear(elem);
		}
		else if(pos > 0 && pos <= getCount()) {
			Node newNode = new Node(elem);
			Node curr = head;
			Node prev = null;
			int ind = 1;
			while(ind < pos) {
				prev = curr;
				curr = curr.next;
				ind++;
			}
			newNode.next = curr;
			curr.prev = newNode;
			prev.next = newNode;
			newNode.prev = prev;
		}
		else {
			throw new RuntimeException("Wrong Position...!!!");
		}
	}
	
	@Override
	public int deleteFromFront() {
		if(getCount() == 0) {
			throw new RuntimeException("LinkedList is Empty...!!!");
		}else if(getCount() == 1) {
			head = null;
			tail = null;
			return -1;
		}else {
			Node curr = head;
			head = curr.next;
			head.prev = null;
			curr.next = null;
			return curr.data;
		}
	}
	
	@Override
	public int deleteFromRear() {
		if(getCount() == 0) {
			throw new RuntimeException("LinkedList is Empty...!!!");
		}else if(getCount() == 1) {
			head = null;
			tail = null;
			return -1;
		}else {
			Node curr = tail;
			tail = tail.prev;
			curr.prev = null;
			return curr.data;
		}
	}
	
	@Override
	public int deleteFromPos(int pos) {
		if(getCount() == 0) {
			throw new RuntimeException("LinkedList is Empty...!!!");			
		}else if(getCount() >= 1 && pos == 1) {
			return deleteFromFront();
		}else if(pos == getCount()) {
			return deleteFromRear();
		}else if(pos >= 1 && pos <= getCount()){
			Node curr = head;
			Node prev = null;
			int ind = 1;
			while(ind < pos) {
				prev = curr;
				curr = curr.next;
				ind++;
			}
			curr.next.prev = prev.next;
			prev.next = curr.next;
			curr.prev = null;
			curr.next = null;
			return curr.data;
		}else
			throw new RuntimeException("Wrong..!!!");			
	}
	

	public int deleteElementUsingTail(int elem) {
		Node curr = tail;
		Node prev = null;
		int res = 0;
		while(curr != head) {
			if(curr.data == elem) {
				break;
			}
			prev = curr;
			curr = curr.prev;
		}
		if(curr == head && curr.data != elem) {
			throw new RuntimeException("Element is not present in list...");
		}
		else if(curr == head && curr.data == elem) {
			if(curr == tail) {
				res = curr.data;
				head = tail = curr = null;
				return res;
			}
			head = prev;
			res = curr.data;
			curr.next = null;
		}
		res = curr.data;
		if(curr == tail) {
			curr.prev.next = null;
			tail = curr.prev;
			curr = null;
		}else {
			prev.prev = curr.prev;
			curr.prev.next = prev;
			curr = null;
		}
		return res;
	}

	@Override
	public int[] getElementsInFowardDir() {
		int[] elems = new int[getCount()];
		Node curr = head;
		int i = 0;
		while(curr != null) {
			elems[i++] = curr.data;
			curr = curr.next;
		}
		return elems;
	}

	@Override
	public int[] getElementsInBackwardDir() {
		int[] elems = new int[getCount()];
		Node curr = tail;
		int i = 0;
		while(curr != null) {
			elems[i++] = curr.data;
			curr = curr.prev;
		}
		return elems;
	}

	public int getCount() {
		int count = 0;
		Node curr = head;
		while(curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}
}