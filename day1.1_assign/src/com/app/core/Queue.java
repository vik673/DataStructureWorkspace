package com.app.core;

import customException.QueueHandlingException;

public class Queue implements QueueIntf {
	private int size;
	private int[] queue;
	private int first;
	private int end;

	public Queue() {
		//default size = 5
		//constructor chaining
		this(5);
	}
	
	public Queue(int size) {
		this.size = size;
		this.queue = new int[size];
		this.first = -1;
		this.end = -1;
	}
	
	@Override
	public void addQ(int elem) throws QueueHandlingException {
		if(!isFull()) {
			if(first == -1 && end == -1) {
				first = 0;
			}
			queue[++end] = elem;
		}else {
			if(first > end)
				throw new QueueHandlingException("Renew the Queue...!!! \nfirst position is greater than end position...!!!");
			throw new QueueHandlingException("Queue is Full...!!!");
		}
	}

	@Override
	public int deleteQ() throws QueueHandlingException {
		if(!isEmpty()) {
			int popedElem = queue[first];
			first++;
			return popedElem;
		}
		throw new QueueHandlingException("Queue is Empty...!!!");
	}

	@Override
	public boolean isEmpty(){
		if(first > end) {
			System.out.println("\nRequire to renew....");
			renewQueue();
			return true;
		}
		if((first == -1 && end == -1 )) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(end > size-2 || first > end) {
			return true;
		}
		return false;
	}
	
	public  void renewQueue() {
		first = end = -1;
		System.out.println("first = "+first+", end = "+end);
	}
	
	public void showQueue() {
		for(int i = first; i<= end;i++) {
			System.out.print(queue[i] + " ");
		}
	}
	public void reverseQueue() {
		for(int i=end;i>=first;i++) {
			System.out.println(queue[i] + " ");
		}		
	}
	
	public void revQueueCheck(Queue obj, int[] arr) {
		int i = 0;
		while(i<arr.length && !isFull()) {
			if(end == -1 && first == -1) {
				first = 0;
			}
			queue[++end] = arr[i++];
		}
		while(i >= 0 && !isEmpty()) {
			System.out.print(queue[first]+" ");
			queue[first++] = 0;
			i--;
		}	
	}
}
