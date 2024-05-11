package collections;

public class StackUsingLL<T> implements IStack<T> {

	private CircularLinkedList<T> list;
	private int top;
	private final int SIZE;

	public StackUsingLL(int size) {
		list = new CircularLinkedList<T>();
		SIZE = size;
		top = -1;
	}

	@Override
	public T pop() {
		if(isEmpty())
			throw new RuntimeException("Stack UnderFlow!!");
		top--;
		return list.removeAtFront();
	}

	@Override
	public void push(T e) {
		if (isFull())
			throw new RuntimeException("Stack OverFlow!!");
		top++;
		list.addAtFront(e);
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top == SIZE - 1;
	}

	@Override
	public T peek() {
		T e = list.removeAtFront();
		list.addAtFront(e);
		return e;
	}

}
