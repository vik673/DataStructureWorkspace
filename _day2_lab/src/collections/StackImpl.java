package collections;


import java.util.Arrays;

@SuppressWarnings("unchecked")
public class StackImpl<T> implements IStack<T> {

	private final int SIZE;
	private int top;
	private Object[] stack;

	public StackImpl(int size) {
		SIZE = size;
		stack = new Object[SIZE];
		top = -1;
		System.out.println("Created stack of size : "+SIZE);
	}

	@Override
	public T pop() throws RuntimeException {
		if (isEmpty())
			throw new RuntimeException("STACK UNDERFLOW!!");

		return (T)stack[top--];
	}

	@Override
	public void push(T e) throws RuntimeException {
		if (isFull())
			throw new RuntimeException("STACK OVERFLOW!!");
		else
			stack[++top] = e;
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
		if(isEmpty())
			throw new RuntimeException("STACK UNDERFLOW!!");
		return (T)stack[top];
	}
	
	public int elementCount() {
		return top+1;
	}
	
	public void showAll() {
		Arrays.stream(stack).forEach(System.out::println);
	}

	@Override
	public String toString() {
		String stackStr = "[";
		for(int i=0; i<top+1; i++)
			stackStr+=" "+stack[i]+",";
		stackStr+="]";
		return stackStr;
	}
	
	

}
