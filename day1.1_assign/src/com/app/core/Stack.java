package com.app.core;

import customException.StackHandlingException;

public class Stack implements StackIntf {
	private int size;
	private int[] stack;
	private int top;
	
	public Stack() {
		//default size = 5
		//Constructor chaining
		this(5);
	}
	
	public Stack(int size) {
		this.size = size;
		this.stack = new int[size];
		this.top = -1;
	}
	@Override
	public void push(int elem) throws StackHandlingException{
		if(!isFull()) {
			stack[++top] = elem;
		}
		else
			throw new StackHandlingException("Stack is Full...!!!");
	}

	@Override
	public int pop() throws StackHandlingException {
		if(!isEmpty()) {
			int popedElem = stack[top];
			top--;
			return popedElem;
		}
		throw new StackHandlingException("Stack is Empty...!!!");
	}

	@Override
	public boolean isEmpty() {
		if(top < 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(top > size-2) {
			return true;
		}
		return false;
	}
	
	public void showStack() {
		for(int i=0;i<=top;i++) {
			System.out.println(stack[i] + " ");
		}
	}
	
	public void reverseStack() {
		for(int i=top;i>=0;i++) {
			System.out.println(stack[i] + " ");
		}		
	}
	
	public void revStackCheck(Stack obj, int[] arr) {
		int i = 0;
		while(!isFull() && i<arr.length) {
			stack[++top] = arr[i++];
		}
		while(!isEmpty() && i >= 0) {
			System.out.print(stack[top]+" ");
			stack[top] = 0;
			top--;
			i--;
		}	
		
	}
}
