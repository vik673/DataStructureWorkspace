package collections;

@SuppressWarnings("unchecked")
public class CircularQueueImpl2<T> implements IQueue<T> {

	private Object[] queue;
	private final int SIZE;
	private int front;
	private int rear;

	public CircularQueueImpl2(int size) {
		SIZE = size+1;
		queue = new Object[SIZE];
		front = 0;
		rear = 0;
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	@Override
	public boolean isFull() {
		return (rear+1)%SIZE==front;
	}

	@Override
	public T remove() throws RuntimeException {
		if (isEmpty())
			throw new RuntimeException("Empty Queue!!");
		front=(front+1)%SIZE;
		T a= (T)queue[front];
		return a;
	}

	@Override
	public void add(T e) throws RuntimeException {
		if (isFull())
			throw new RuntimeException("Full Queue!!");
		rear=(rear+1)%SIZE;
		queue[rear]=e;
	}

	@Override
	public T peek() {
		if(isEmpty())
			throw new RuntimeException("Empty Queue!!");
		return  (T)queue[front+1];
	}

}
