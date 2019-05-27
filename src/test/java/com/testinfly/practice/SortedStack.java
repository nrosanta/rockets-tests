package com.testinfly.practice;

import java.util.Map;
import java.util.Stack;

class MyStack {
	private Stack<Integer> stk1;
	private Stack<Integer> stk2;

	MyStack() {
		stk1 = new Stack<Integer>();
		stk2 = new Stack<Integer>();
	}

	public void push(int item) {
		if (stk1.isEmpty()) {
			stk1.push(item);
			//System.out.println(stk1.peek());
		} else if (item>stk1.peek()) {
			resetStack(item);
			//System.out.println("debug1: "+stk1.peek());
		}else
			stk1.push(item);
		
	}

	public int pop() {
		return stk1.pop();
	}

	public int peek() {
		return stk1.peek();
	}

	private void resetStack(int item) {
		//print();
		while(item>stk1.peek()) {
			
				//System.out.println("debug: "+stk1.peek());
				stk2.push(stk1.pop());
			
		}

		stk1.push(item);
		while (!stk2.isEmpty()) {
			stk1.push(stk2.pop());
		}
	}

	public void print() {
		System.out.println(stk1);
	}
	
	
}

public class SortedStack {
	public static void main(String[] args) {
			
		MyStack stk = new MyStack();
		stk.push(10);
		stk.push(3);
		stk.push(1);
		stk.push(7);
		stk.push(4);
		stk.push(2);
		
		stk.print();
		System.out.println(stk.peek());

	}

}
