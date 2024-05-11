package com.app.core;

public class Node {
	public int data;
	public Node next, prev;
	
	public Node(int elem) {
		this.data = elem;
		this.next = null;
		this.prev = null;
	}
}
