package org.edac.example3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackUsingLinkedListTest {

	@Test
	void test() {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		assertTrue(stack.getElements()[0] == 30);
		assertTrue(stack.getElements()[1] == 20);
		assertTrue(stack.getElements()[2] == 10);

	}
	
	@Test
	void test1() {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		assertThrows(RuntimeException.class, ()->{
			stack.pop();
		});
		
		stack.push(10);
		stack.push(20);

		assertTrue(stack.pop() == 20);
		assertTrue(stack.pop() == 10);


		
	}

}
