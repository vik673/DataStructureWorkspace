package com.app.example1;


public class SinglyLinkedList implements LinkedListIntf {
	public Node head, tail;

	public SinglyLinkedList() {
		head = tail = null;
	}

	@Override
	public void AddAtFront(int element) {
		Node newNode = new Node(element);
		if(head == null) {
			tail = newNode;
		}
		newNode.next = head;
		head = newNode;
	}

	@Override
	public void AddAtRear(int element) {
		Node newNode = new Node(element);
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
		}
		else {
			Node curr = head;
			while(curr.next != null) 
				curr = curr.next;
			curr.next = newNode;
			tail = newNode;
		}
	}

	@Override
	public void AddAtPos(int element, int pos) {
		Node newNode = new Node(element);
		if(pos > GetNodeCount() + 1 && pos >= 1) {
			throw new RuntimeException("Wrong Position !");
		}
		else {
			if(pos == 1) {
				AddAtFront(element);
			}
			else if(pos == GetNodeCount() + 1) {
				AddAtRear(element);
			}
			else {
				Node curr = head;
				int index = 0;
				while(index < pos - 2 && curr.next != null) {
					curr = curr.next;
					index++;
				}
				newNode.next = curr.next;
				curr.next = newNode;
			}
		}
	}

	@Override
	public int DeleteFromFront() {
		if(isEmpty()) {
			throw new RuntimeException("LinkedList is Empty");
		}
		if(head == tail) {
			tail = null;
		}
		Node newNode = head;
		head = head.next;
		int elem = newNode.data;
		newNode.data = 0;
		newNode.next = null;
		return elem;
	}

	@Override
	public int DeleteFromRear() {
		if(isEmpty())
			throw new RuntimeException("LinkedList is Empty");
		int elem = 0;
		if(GetNodeCount() == 1) {
			elem = head.data;
			head = tail = null;
		}
		else {
			Node curr = head;
			while(curr.next.next != null) 
				curr = curr.next;
			elem = curr.next.data;
			tail = curr;
			curr.next = null;
		}
		return elem;
	}

	@Override
	public int DeleteFromPos(int pos) {
		if(pos > GetNodeCount() && pos >= 1) {
			throw new RuntimeException("Wrong Position !");
		}
		else {
			int elem = 0;
			if(pos == 1) {
				elem = DeleteFromFront();
			}
			else if(pos == GetNodeCount()) {
				elem = DeleteFromRear();
			}
			else {
				Node curr = head;
				int index = 0;
				while(index < pos - 2 && curr.next != null) {
					curr = curr.next;
					index++;
				}
				Node deleted = curr.next;
				curr.next = deleted.next;
				elem = deleted.data;
				deleted.data = 0;
				deleted.next = null;
			}
			return elem;
		}
	}
	
	
	public boolean isEmpty() {
		return head == null;
	}
	
	@Override
	public int[] GetAllElements() {
		int[] listElements;
/*
		if (head == null) {
			listElements = new int[0];
			return listElements;
		}
*/
		listElements = new int[GetNodeCount()];
		int i = 0;
		Node curr = head;

		while (curr != null) {
			listElements[i] = curr.data;
			++i;
			curr = curr.next;
		}
		return listElements;
	}

	public int GetNodeCount() {
		int count = 0;
		Node curr = head;

		// Algo: While current is not empty.
		while (curr != null) {
			++count;
			curr = curr.next;
		}

		return count;
	}

	@Override
	public int deleteElementUsingTail(int elem) {
		Node curr = head;
		Node prev = null;
		int res = 0;
		while(curr != null) {
			if(curr.data == elem) {
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		if(curr == null) {
			throw new RuntimeException("Element is not present in list...");
		}
		res = curr.data;
		if(curr == head) {
			return DeleteFromFront();
		}
		else if(curr == tail) {
			return DeleteFromRear();
		}else {
			prev.next = curr.next;
			curr.next = null;
		}
		return res;
	}
}
