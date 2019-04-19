package com.testingfly.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class IntersectionOf2SinglyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		while (headA != null) {
			set.add(headA);
			headA = headA.next;
		}

		while (headB != null) {
			if (set.add(headB))
				return headB;
			headB = headB.next;
		}

		return null;

	}

	/*
	 * Using hash set
	 */
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		ListNode temp = headA;
		while (temp != null) {
			set.add(temp);
			temp = temp.next;
		}
		temp = headB;
		while (temp != null) {
			if (!set.add(temp))
				return temp;
			temp = temp.next;
		}
		return null;
	}

	/*
	 * using 2 pointers and finding intersection
	 */
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

		if (headA == null || headB == null)
			return null;
		
		if (headA == headB)
			return headA;

		ListNode p1 = headA;
		ListNode p2 = headB;

		while (p1 != p2) {

			if (p1 == null)
				p1 = headB;

			if (p2 == null)
				p2 = headA;

			if (p1 == p2)
				return p2;

			p1 = p1.next;
			p2 = p2.next;

		}
		return p1 == p2 && p2 != null ? p1 : null;
	}

}