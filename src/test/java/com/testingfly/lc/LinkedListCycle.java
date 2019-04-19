package com.testingfly.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasCycle1(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while (head != null) {
			if (set.contains(head))
				return true;
			set.add(head);
			head = head.next;
		}
		return false;
	}

	/*
	 * alternate approach using two pointers to track the elements, one moving at
	 * twice the speed.
	 */
	public boolean hasCycle2(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode p1 = head;
		ListNode p2 = head.next;

		while (p1 != p2) {
			if (p2 == null || p2.next == null)
				return false;

			p1 = p1.next;
			p2 = p2.next.next;

		}
		return true;
	}

	/*
	 * alternate recursive solution
	 */

	public boolean hasCycle(ListNode head) {
		return hasCycle(head, head);
	}
	
	public boolean hasCycle(ListNode p1, ListNode p2) {
		if (p2 == null || p2.next == null) return false;
		p1 = p1.next;
		p2 = p2.next.next;
		if(p1==p2) return true;
		return hasCycle(p1, p2);
	}
	

}