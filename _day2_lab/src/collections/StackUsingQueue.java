package collections;

public class StackUsingQueue<T> implements IStack<T> {

	IQueue<T> queue;
	private int top;
	private final int SIZE;
	
	public StackUsingQueue(int size) {
		SIZE = size;
		top=-1;
		queue=new CircularQueueImpl2<T>(SIZE);
	}
	
	
	@Override
	public T pop() {
		if(isEmpty())
			throw new RuntimeException("Stack empty!!");
		T a=null;
		IQueue<T> tempQueue = new CircularQueueImpl2<T>(top);
		for(int i=0;i<top;i++)
			tempQueue.add(queue.remove());
		a=queue.remove();
		for(int i=0; i < top;i++)
			queue.add(tempQueue.remove());
		top--;
		return a;
	}

	@Override
	public void push(T e) {
		if(isFull())
			throw new RuntimeException("Stack Full!!!");
		queue.add(e);
		top++;
	}

	@Override
	public boolean isEmpty() {
		return top==-1;
	}

	@Override
	public boolean isFull() {
		return top==SIZE-1;
	}

	@Override
	public T peek() {
		if(isEmpty())
			throw new RuntimeException("Stack empty!!");
		T a=null;
		IQueue<T> tempQueue = new CircularQueueImpl2<T>(top);
		for(int i=0;i<top;i++)
			tempQueue.add(queue.remove());
		a=queue.remove();
		for(int i=0; i < top;i++)
			queue.add(tempQueue.remove());
		queue.add(a);
		return a;
	}

}
