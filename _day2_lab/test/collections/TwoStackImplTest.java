package collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoStackImplTest {
	
	TwoStackImpl<Integer> twoStacks;
	
	@BeforeEach
	void setUp() throws Exception {
		twoStacks = new TwoStackImpl<Integer>(5);
	}

	@AfterEach
	void tearDown() throws Exception {
		twoStacks=null;
	}

	@Test
	void testEmpty() {
		assertTrue(twoStacks.isEmptyOne()&&twoStacks.isEmptyTwo());
		
	}
	
	@Test
	void testNotEmpty() {
		twoStacks.pushOne(1);
		twoStacks.pushTwo(2);
		assertFalse(twoStacks.isEmptyOne()||twoStacks.isEmptyTwo());

	}
	
	
	
	@Test
	void testTop() {
		twoStacks.pushOne(1);
		twoStacks.pushOne(2);
		twoStacks.pushOne(3);
		twoStacks.pushTwo(4);
		twoStacks.pushTwo(5);
		assertEquals(5, twoStacks.peekTwo());
		assertEquals(3, twoStacks.peekOne());
	}
	
	@Test
	void testOverFlowOne() {

		twoStacks.pushOne(1);
		twoStacks.pushOne(2);
		twoStacks.pushOne(3);
		assertThrows(RuntimeException.class, ()->twoStacks.pushOne(4));
	}
	
	
	@Test
	void testOverFlowTwo() {
		twoStacks.pushTwo(1);
		twoStacks.pushTwo(2);
		assertThrows(RuntimeException.class, ()->twoStacks.pushTwo(4));
	}
	
	@Test
	void testUnderFlow() {
		assertThrows(RuntimeException.class, ()->twoStacks.popOne());
		assertThrows(RuntimeException.class, ()->twoStacks.popTwo());
	}

	@Test
	void testPopOne() {
		twoStacks.pushOne(1);
		twoStacks.pushOne(3);
		twoStacks.pushOne(2);
		assertEquals(2, twoStacks.popOne());
		assertEquals(3, twoStacks.popOne());
		assertEquals(1, twoStacks.popOne());
	}
	
	
	@Test
	void testPopTwo() {
		twoStacks.pushTwo(1);
		twoStacks.pushTwo(3);
		assertEquals(3, twoStacks.popTwo());
		assertEquals(1, twoStacks.popTwo());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
