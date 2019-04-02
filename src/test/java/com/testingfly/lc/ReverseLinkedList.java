package com.testingfly.lc;

import java.util.Stack;

/**
 * 
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 *
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode reverseList1(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		while (head != null) {
			stack.add(head.val);
			head = head.next;
		}

		ListNode node = new ListNode(0);
		ListNode temp = node;
		while (!stack.empty()) {
			temp.next = new ListNode(stack.pop());
			temp = temp.next;
		}

		return node.next;
	}

	// recursive solution to copy LL
	public static ListNode copyList(ListNode head, ListNode node) {
		if (head == null)
			return null;
		node.next = new ListNode(head.val);
		head = head.next;
		return copyList(head, node.next);

	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode move = head.next;
			head.next = prev;
			prev = head;
			head = move;
		}
		return prev;
	}
	
	
	/*
	 * Recursive Solution
	 */
    public ListNode reverseListRecursive(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode rev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }

}
