package collections;

public interface IQueue<T> {

	boolean isEmpty();

	boolean isFull();

	T remove();

	void add(T e);

	T peek();

}
