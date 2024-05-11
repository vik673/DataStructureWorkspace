package com.app.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {

	@Test
	void testForEmptyInitially() {
		Stack s = new Stack();
		assertTrue(s.isEmpty());
	}
	@Test
	void testForFullInitially() {
		Stack s = new Stack();
		assertFalse(s.isFull());
	}
}
