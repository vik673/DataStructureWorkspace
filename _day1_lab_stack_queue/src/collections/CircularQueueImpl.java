package collections;


@SuppressWarnings("unchecked")
public class CircularQueueImpl<T> implements IQueue<T> {

	private Object[] queue;
	private final int SIZE;
	private int front;
	private int rear;

	public CircularQueueImpl(int size) {
		SIZE = size;
		queue =  new Object[SIZE];
		front = -1;
		rear = -1;
	}

	@Override
	public boolean isEmpty() {
		return front == -1;
	}

	@Override
	public boolean isFull() {
		return (rear+1)%SIZE==front;
	}

	@Override
	public T remove() throws RuntimeException {
		if (isEmpty())
			throw new RuntimeException("Empty Queue!!");
		T a= (T)queue[front];
		front++;
		front=front%SIZE;
		if(isFull())
			front=rear=-1;
		return a;
	}

	@Override
	public void add(T e) throws RuntimeException {
		if (isFull())
			throw new RuntimeException("Full Queue!!");
		rear++;
		rear=rear%SIZE;
		if(isEmpty())
			front=rear=0;
		queue[rear]=e;
	}

	@Override
	public T peek() {
		if(isEmpty())
			throw new RuntimeException("Empty Queue!!");
		return (T)queue[front];
	}

}
