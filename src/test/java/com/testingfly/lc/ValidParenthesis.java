package com.testingfly.lc;

import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValid(String s) {
		Stack<Character> stk = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[')
				stk.push(c);
			else if (c == ')' && !stk.isEmpty() && stk.peek() == '(')
				stk.pop();
			else if (c == '}' && !stk.isEmpty() && stk.peek() == '{')
				stk.pop();
			else if (c == ']' && !stk.isEmpty() && stk.peek() == '[')
				stk.pop();
			else
				return false;
		}
		if (stk.isEmpty())
			return true;
		return false;
	}

}
