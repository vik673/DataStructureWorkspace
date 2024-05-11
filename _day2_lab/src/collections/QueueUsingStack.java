package collections;

public class QueueUsingStack<T> implements IQueue<T> {

	IStack<T> stack;

	private final int SIZE;

	public QueueUsingStack(int size) {
		SIZE = size;
		stack = new StackImpl<>(size);
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack.isFull();
	}

	@Override
	public T remove() {
		if (isEmpty())
			throw new RuntimeException("Queue Empty!!");
		IStack<T> tempStack = new StackImpl<T>(SIZE);
		while (!stack.isEmpty())
			tempStack.push(stack.pop());
		T a = tempStack.pop();
		while (!tempStack.isEmpty())
			stack.push(tempStack.pop());
		return a;
	}

	@Override
	public void add(T e) {
		if (isFull())
			throw new RuntimeException("Queue Full!!");
		stack.push(e);
	}

	@Override
	public T peek() {
		if (isEmpty())
			throw new RuntimeException("Queue Empty!!");
		IStack<T> tempStack = new StackImpl<T>(SIZE);
		while (!stack.isEmpty())
			tempStack.push(stack.pop());
		T a = tempStack.peek();
		while (!tempStack.isEmpty())
			stack.push(tempStack.pop());
		return a;
	}

}
