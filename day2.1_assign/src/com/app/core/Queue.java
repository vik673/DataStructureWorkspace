package com.app.core;

public class Queue extends CircularQueue{
    private int[] queue;
    private int size;
    private int front, rear;
    
    public Queue(int size){
    	this.size = size;
        queue = new int[size];
        front=-1;
        rear=-1;
     }

	@Override
	public void add(int ele) {
        if(front == -1){
            rear=front=0;
        }
        else if(rear == (size-1) && front!=0){
            rear=0;
        }
        else{
            rear++;
        }
        queue[rear]=ele;		
	}

	@Override
	public void delete() {
        queue[front]=-1;
        if(front == rear){
            front=-1;
            rear=-1;
        }
        else if(front == size-1){
            front=0;;
        }
        else{
            front++;
        }		
	}

    public void traverse(){
    	System.out.println("---Circular Queue---");
    	if (rear >= front)
            for (int i = front; i <= rear; i++)
                System.out.println(queue[i]);
        else {
            for (int i = front; i < size; i++)
                System.out.println(queue[i]);
            for (int i = 0; i <= rear; i++)
                System.out.println(queue[i]);
        }
    }

	@Override
	public boolean isEmpty() {
        if(front==-1)
            return true;
        return false;
 	}

	@Override
	public boolean isFull() {
		if((front==0 && rear==size-1) || rear==(front-1)%(size-1))
			return true;
		return false;
	}

}
