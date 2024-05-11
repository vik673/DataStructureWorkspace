package test;

import static com.rec.Arithematic.div;
import static com.rec.Arithematic.mul;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestArithmetic {

	@Test
	void testMul() {
		assertEquals(10, mul(2, 5));
		assertEquals(10, mul(5, 2));
	}

	@Test
	void testMulNeg() {
		assertEquals(-10, mul(-2, 5));
		assertEquals(-10, mul(5, -2));
	}

	@Test
	void testMulBothNeg() {
		assertEquals(10, mul(-2, -5));
		assertEquals(10, mul(-5, -2));
	}

	@Test
	void testMulZero() {
		assertEquals(0, mul(0, -5));
		assertEquals(0, mul(-5, 0));
	}

	@Test
	void testDiv() {
		assertEquals(5, div(10, 2));
		assertEquals(5, div(11, 2));
	}

	@Test
	void testDivNeg() {
		assertEquals(-5, div(-10, 2));
		assertEquals(-5, div(11, -2));
	}

	@Test
	void testDivBothNeg() {
		assertEquals(5, div(-10, -2));
		assertEquals(5, div(-11, -2));
	}

	@Test
	void testDivZero() {
		assertEquals(0, div(0, -2));
		assertEquals(0, div(1, -2));
	}

	@Test
	void testDivZeroExc() {
		assertThrows(RuntimeException.class, () -> div(-2, 0));
		assertThrows(RuntimeException.class, () -> div(0, 0));
	}

}
