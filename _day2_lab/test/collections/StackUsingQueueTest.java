package collections;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StackUsingQueueTest {

	@Test
	void test1() {
		IStack<Integer> stack = new StackUsingQueue<>(3);
		stack.push(1);
		assertTrue(stack.pop()==1);
	}
	
	@Test
	void test2() {
		IStack<Integer> stack = new StackUsingQueue<>(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertTrue(stack.pop()==3);
	}
	
	@Test
	void test3() {
		IStack<Integer> stack = new StackUsingQueue<>(3);
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.push(3);
		stack.pop();
		assertTrue(stack.peek()==1);
	}
	
	@Test
	void test4() {
		IStack<Integer> stack = new StackUsingQueue<>(3);
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.push(3);
		stack.pop();
		assertTrue(stack.peek()==1&&stack.pop()==1);
	}
	
	@Test
	void test5() {
		IStack<Integer> stack = new StackUsingQueue<>(3);
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.push(3);
		stack.pop();
		stack.push(4);
		stack.push(5);
		assertThrows(RuntimeException.class, ()->stack.push(6));
	}
	
	@Test
	void test6() {
		IStack<Integer> stack = new StackUsingQueue<>(3);
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.push(3);
		stack.pop();
		stack.pop();
		assertThrows(RuntimeException.class, ()->stack.pop());
	}

}
