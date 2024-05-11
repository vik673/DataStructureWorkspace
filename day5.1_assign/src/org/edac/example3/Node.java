package org.edac.example3;

//node : data | next
public class Node {
	public int data;
	public Node next, prev;

	public Node(int element) {
		//initialize new node
		data = element;
		next = null;
		prev = null;
	}
}
