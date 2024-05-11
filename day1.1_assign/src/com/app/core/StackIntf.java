package com.app.core;

import customException.StackHandlingException;

public interface StackIntf {
	public void push(int elem) throws StackHandlingException;
	public int pop()  throws StackHandlingException ;
	public boolean isEmpty();
	public boolean isFull();
}
