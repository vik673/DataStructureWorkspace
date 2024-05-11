package org.edac.example2;


public class CircularLinkedList implements SortedLinkedListIntf{
	private Node head;
	
	public CircularLinkedList() {
		head = new Node(-1);
		head.prev = head;
		head.next = head;
	}

	@Override
	public void Insert(int element) {
		Node newNode = new Node(element);
		Node curr = head.next;
		while(curr.next != head) {
			if(curr.data > element) {
				break;
			}
			curr = curr.next;
		}
		if(curr != head && curr.data > element) {
			curr.prev.next = newNode;
			newNode.prev = curr.prev;
			newNode.next = curr;
			curr.prev = newNode;	
			return;
		}
		curr.next = newNode;
		newNode.prev = curr;
		newNode.next = head;
		head.prev = newNode;
	}

	
	@Override
	public void Delete(int element) {
		Node curr = head.next;
		while(curr != head) {
			
		}
	}

	@Override
	public int[] GetAllElements() {
		int[] elems = new int[getCount()];
		Node curr = head.next;
		int i =0;
		while(curr != head) {
			elems[i++] = curr.data;
			curr = curr.next;
		}
		return elems;
	}
	
	public int getCount() {
		int cnt = 0;
		Node curr = head.next;
		while(curr != head) {
			cnt++;
			curr = curr.next;
		}
		return cnt;
	}
}
