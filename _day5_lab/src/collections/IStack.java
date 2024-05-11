package collections;

public interface IStack<T> {

	T pop();

	void push(T e);

	boolean isEmpty();

	boolean isFull();

	T peek();
}
