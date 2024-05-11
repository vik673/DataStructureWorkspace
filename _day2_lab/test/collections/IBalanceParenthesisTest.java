package collections;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import utils.BalancedParenthesisImpl;
import utils.IBalanceParenthesis;

class IBalanceParenthesisTest {

	@Test
	void testCheck1() {
		IBalanceParenthesis balance = new BalancedParenthesisImpl("()");
		assertTrue(balance.check());
	}
	@Test
	void testCheck2() {
		IBalanceParenthesis balance = new BalancedParenthesisImpl("{}");
		assertTrue(balance.check());
	}@Test
	void testCheck3() {
		IBalanceParenthesis balance = new BalancedParenthesisImpl("[]");
		assertTrue(balance.check());
	}
	
	@Test
	void testCheck4() {
		IBalanceParenthesis balance = new BalancedParenthesisImpl("(");
		assertFalse(balance.check());
	}
	
	@Test
	void testCheck5() {
		IBalanceParenthesis balance = new BalancedParenthesisImpl("(100)");
		assertTrue(balance.check());
	}
	
	@Test
	void testCheck6() {
		IBalanceParenthesis balance = new BalancedParenthesisImpl("([]{})");
		assertTrue(balance.check());
	}
	
	@Test
	void testCheck7() {
		IBalanceParenthesis balance = new BalancedParenthesisImpl("(){");
		assertFalse(balance.check());
	}
	
	@Test
	void testCheck8() {
		IBalanceParenthesis balance = new BalancedParenthesisImpl("(]()");
		assertFalse(balance.check());
	}
	
	@Test
	void testCheck9() {
		IBalanceParenthesis balance = new BalancedParenthesisImpl("({[]{}})");
		assertTrue(balance.check());
	}

}
