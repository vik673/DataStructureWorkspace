package com.app.core;


public class SortedLinkedList implements SortedLinkedListIntf{
	public SinglyLinkedList list;
	
	public SortedLinkedList() {
		list = new SinglyLinkedList();
	}
	
	@Override
	public void Insert(int element) {
		SinglyListNode newNode = new SinglyListNode(element);
		if(list.isEmpty()) {
			list.AddAtFront(element);
			return;
		}
		SinglyListNode curr = list.head;
		int pos = 1;
		while(curr != null && curr.data < newNode.data) {
			curr = curr.next;
			pos++;
		}
		if(curr == null) {
			list.AddAtRear(element);
		}else {
			list.AddAtPos(element, pos);
		}
	}

	@Override
	public int[] GetAllElements() {
		int[] elements = new int[GetNodeCount()];
		SinglyListNode curr = list.head;
		int index = 0;
		while(curr != null) {
			elements[index++] = curr.data;
			curr = curr.next;
		}
 		return elements;
	}

	public int GetNodeCount() {
		int count = 0;
		SinglyListNode curr = list.head;

		// Algo: While current is not empty.
		while (curr != null) {
			++count;
			curr = curr.next;
		}

		return count;
	}

	public static void main(String[] args) {
		SortedLinkedList sortedll = new SortedLinkedList();
		sortedll.Insert(3);
		sortedll.Insert(1);
		sortedll.Insert(2);
		sortedll.Insert(4);
		sortedll.Insert(5);

		System.out.println("Sorted List : ");
		for(int i : sortedll.GetAllElements()) {
			System.out.print(i + ", ");
		}
	}
}
