package collections;

@SuppressWarnings("unchecked")
public class QueueImpl<T> implements IQueue<T> {

	private Object[] queue;
	private final int SIZE;
	private int front;
	private int rear;

	public QueueImpl(int size) {
		SIZE = size;
		queue = new Object[SIZE];
		front = -1;
		rear = -1;

	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	@Override
	public boolean isFull() {
		return rear == SIZE;
	}

	@Override
	public T remove() throws RuntimeException {
		if (isEmpty())
			throw new RuntimeException("Empty Queue!!");
		return (T)queue[++front];
	}

	@Override
	public void add(T e) throws RuntimeException {
		if (isFull())
			throw new RuntimeException("Full Queue!!");
		queue[++rear]=e;
	}

	@Override
	public T peek() {
		if (isEmpty())
			throw new RuntimeException("Empty Queue!!");
		return (T)queue[front+1];
	}
}
