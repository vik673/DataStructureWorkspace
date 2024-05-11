package collections;

@SuppressWarnings("unchecked")
public class TwoStackImpl<T> implements ITwoStack<T> {

	private int topOne;
	private int topTwo;
	private final int maxOne;
	private final int maxTwo;
	private final int SIZE;
	private Object[] twoStacks;

	public TwoStackImpl(int size) {
		SIZE = size;
		maxOne = (SIZE + 1) / 2;
		maxTwo = SIZE / 2;
		topOne = -1;
		topTwo = SIZE;
		twoStacks = new Object[SIZE];
	}

	@Override
	public T popOne() {
		if (isEmptyOne())
			throw new RuntimeException("Stack One Empty!");
		return (T) twoStacks[topOne--];
	}

	@Override
	public void pushOne(T e) {
		if (isFullOne())
			throw new RuntimeException("Stack One Full!");
		twoStacks[++topOne] = e;
	}

	@Override
	public boolean isEmptyOne() {
		return topOne == -1;
	}

	@Override
	public boolean isFullOne() {
		return topOne == maxOne - 1;
	}

	@Override
	public T peekOne() {
		if (isEmptyOne())
			throw new RuntimeException("Stack One Empty!");
		return (T) twoStacks[topOne];
	}

	@Override
	public T popTwo() {
		if (isEmptyTwo())
			throw new RuntimeException("Stack Two Empty!");
		return (T) twoStacks[topTwo++];
	}

	@Override
	public void pushTwo(T e) {
		if (isFullTwo())
			throw new RuntimeException("Stack Two Full!");
		twoStacks[--topTwo] = e;

	}

	@Override
	public boolean isEmptyTwo() {
		return topTwo == SIZE;
	}

	@Override
	public boolean isFullTwo() {
		return topTwo == maxTwo + 1;
	}

	@Override
	public T peekTwo() {
		if (isEmptyTwo())
			throw new RuntimeException("Stack Two Empty!");
		return (T) twoStacks[topTwo];
	}

}
