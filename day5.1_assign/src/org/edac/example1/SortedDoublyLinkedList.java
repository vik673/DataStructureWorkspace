package org.edac.example1;


public class SortedDoublyLinkedList implements SortedLinkedListIntf {
	DoublyLinkedList dlist;
	public SortedDoublyLinkedList() {
		dlist = new DoublyLinkedList();
	}
	
	@Override
	public void Insert(int elem) {
		Node newNode = new Node(elem);
		//if list is empty
		if(dlist.head == null) {
			//assign head and tail to the first added elem
			dlist.addAtFront(elem);
			//stop
			return;
		}
		//curr node assign to list head 
		Node curr = dlist.head;
		//while curr not equal to null and elem is greater than curr data do
		while(curr.next != null) {
			//curr data greater than elem
			if(elem < curr.data) {
				//exit while loop
				break;
			}
			curr = curr.next;
		}
		//if element is greater than curr node data
		if(curr.data < elem) {
			//check curr node is head or tail
			if(curr == dlist.tail) {
				dlist.addAtRear(elem);
				return;
			}
			newNode.next = curr.next;
			curr.next.prev = newNode;
			curr.next = newNode;
			newNode.prev = curr;
		}
		else {
			if(curr == dlist.head) {
				dlist.addAtFront(elem);
				return;
			}				
			curr.prev.next = newNode;
			newNode.prev = curr.prev;
			newNode.next = curr;
			curr.prev = newNode;
		}
	}

	@Override
	public int[] GetAllElements() {
		int[] elems = new int[countElem()];
		Node curr = dlist.head;
		int i = 0;
		while(curr != null) {
			elems[i++] = curr.data;
			curr = curr.next;
		}
		return elems;
	}
	
	public int countElem() {
		Node curr = dlist.head;
		int cnt = 0;
		while(curr != null) {
			cnt++;
			curr = curr.next;
		}
		return cnt;
	}

	public static void main(String[] args) {
		SortedDoublyLinkedList list = new SortedDoublyLinkedList();
		int ele1 = 2;
		int ele2 = 4;
		int ele3 = 1;
		int ele4 = 3;
		int ele5 = 5;
		
		
		list.Insert(ele1);
		list.Insert(ele2);
		list.Insert(ele3);
		list.Insert(ele4);
		list.Insert(ele5);
		
		for(int i : list.GetAllElements()) {
			System.out.print(i+ " -> ");
		}
	}
}
