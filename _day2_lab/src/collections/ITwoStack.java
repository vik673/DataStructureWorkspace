package collections;

public interface ITwoStack<T> {

	T popOne();

	void pushOne(T e);

	boolean isEmptyOne();

	boolean isFullOne();

	T peekOne();
	
	T popTwo();

	void pushTwo(T e);

	boolean isEmptyTwo();

	boolean isFullTwo();

	T peekTwo();
}
