package com.testingfly.lc;

import java.util.ArrayList;
import java.util.List;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	getMin() -- Retrieve the minimum element in the stack.
	Example:
	
	MinStack minStack = new MinStack();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	minStack.getMin();   --> Returns -3.
	minStack.pop();
	minStack.top();      --> Returns 0.
	minStack.getMin();   --> Returns -2.
 */
public class MinStack {

	/** initialize your data structure here. */
	List<Integer> stack = new ArrayList<>();
	int min;
	int current_index;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public MinStack() {
		current_index = -1;
	}

	public void push(int x) {
		stack.add(x);
		current_index++;
		if (current_index == 0)
			min = stack.get(0);
		else if (x < min)
			min = x;
	}

	public void pop() {
		int temp = stack.get(current_index);
		stack.remove(current_index);
		current_index--;
		if (temp == min && stack.size() > 0)
			setMin();

	}

	public void setMin() {
		min = stack.get(0);
		for (int i : stack) {
			if (i < min)
				min = i;
		}
	}

	public int top() {
		return stack.get(current_index);
	}

	public int getMin() {
		return min;
	}
}
/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */