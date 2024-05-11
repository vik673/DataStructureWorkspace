package org.edac.example1;


public class DoublyLinkedList implements IDoublyLinkedList{
	public Node head, tail;
	
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
	@Override
	public void deleteElementUsingHead(int elem) {
		//set curr at first node of list
		Node curr = head;
		Node prev = null;
		//while (curr is not empty) do
		while(curr != null) {
			//if curr node's data is elem then
			if(curr.data == elem) {
				//end the loop -- found the elem to be found
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		//if curr node is empty then
		if(curr == null) {
			//no elem found -- stop
			return;
		}
		//delete first node
		if(curr == head) {
			head = curr.next;
			if(head == null) {
				tail = null;
			}else {
				head.prev = null;
			}
			return;
		}
		//if curr node is the last node
		if(curr == tail) {
			curr.prev.next = curr.next;
			tail = curr.prev;
			//stop
			return;
		}
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
		curr.next = null;
		curr.prev = null;
		return;
	}

	public void deleteElementUsingTail(int elem) {
		Node curr = tail;
		while(curr != head) {
			if(curr.data == elem) {
				break;
			}
			curr = curr.prev;
		}
		if(curr == head && curr.data != elem) {
			return;
		}
		
		if(curr == head && curr.data == elem) {
			head = curr.next;
			if(head == null) {
				tail = null;
				return;
			}
			head.prev = null;
			return;
		}
		
		if(curr == tail) {
			curr.prev.next = null;
			tail = curr.prev;
			return;
		}
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
		curr.next = curr.prev = null;
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