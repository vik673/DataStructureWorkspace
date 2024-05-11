package utils;

import java.util.regex.Pattern;

import collections.IStack;
import collections.StackImpl;

public class BalancedParenthesisImpl implements IBalanceParenthesis {

	private IStack<String> stack;
	private String parentheses;
	private static Pattern opening;
	private static Pattern closing;
	static {
		opening = Pattern.compile("[\\{\\(\\[]"); // anyone of { ( [
		closing = Pattern.compile("[\\}\\)\\]]"); // anyone of } ) ]
	}

	public BalancedParenthesisImpl(String parentheses) {
		stack = new StackImpl<>(parentheses.length());
		this.parentheses = parentheses;
	}

	@Override
	public boolean check() {
		for (String p : parentheses.split("")) {
			if (opening.matcher(p).matches()) {
				stack.push(p);
			} else if (closing.matcher(p).matches()) {
				if (p.equals("}"))
					if (stack.pop().equals("{"))
						continue;
					else
						return false;

				if (p.equals("]"))
					if (stack.pop().equals("["))
						continue;
					else
						return false;
				if (p.equals(")"))
					if (stack.pop().equals("("))
						continue;
					else
						return false;

			} else
				continue;
		}
		return stack.isEmpty();
	}

}
