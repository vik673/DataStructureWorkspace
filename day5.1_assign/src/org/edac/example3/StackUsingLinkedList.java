package org.edac.example3;


public class StackUsingLinkedList implements StackIntf{
	private Node top;
	public Node head;

	public StackUsingLinkedList() {
		head = null;
		top = null;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void push(int elem) {
		Node newNode = new Node(elem);
		if(head ==  null) {
			head = top = newNode;
			return;
		}
		top.next = newNode;
		newNode.prev = top;
		top = newNode;
	}

	@Override
	public int pop() {
		if(head == null) {
			throw new RuntimeException("Stack is  empty...!!!");
		}
		int res = top.data;
		if(head == top) {
			head = top = null;
		}else {
			top.prev.next = null;
			top = top.prev;
		}
		return res;
	}

	@Override
	public boolean isFull() {
		
		return false;
	}

	public int[] getElements() {
		int[] elems = new int[getCount()];
		int i = 0;
		Node curr = top;
		while(curr != null) {
			elems[i++] = curr.data;
			curr = curr.prev;
		}
		return elems;
	}
	
	public int getCount() {
		int cnt = 0;
		Node curr = head;
		while(curr != null) {
			cnt++;
			curr = curr.next;
		}
		return cnt;
	}

}
