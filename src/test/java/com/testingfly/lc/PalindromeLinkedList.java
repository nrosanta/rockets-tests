package com.testingfly.lc;

/*
 * Given a singly linked list, determine if it is a palindrome.

	Example 1:
	
	Input: 1->2
	Output: false
	Example 2:
	
	Input: 1->2->2->1
	Output: true
	Follow up:
	Could you do it in O(n) time and O(1) space?
 */
import java.util.ArrayList;
import java.util.List;

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {

	}

	public boolean isPalindrome(ListNode head) {
		List<Integer> list = new ArrayList<>();
		if (head == null || head.next == null)
			return true;
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}

		int len = list.size();
		for (int i = 0; i < len / 2; i++) {
			System.out.println(list.get(i) + "->" + list.get(len - i - 1));
			if (!list.get(i).equals(list.get(len - i - 1)))
				return false;
		}

		return true;
	}

	/**
	 * Picture: node at front, node at end, they compare and move towards each other
	 * 
	 * [] - [] - [] - [] - [] - [] - NULL (f)-> <-(e)
	 * 
	 * -(e) recursions foward and then back -(f) move to next if values equal
	 */

	class Solution {
		ListNode node;

		public boolean isPalindrome(ListNode head) {
			if (head == null)
				return true;
			if (node == null)
				node = head; // node points at front

			boolean bool = isPalindrome(head.next); // send head to end

			if (head.val == node.val) // compare the front and end nodes
				node = node.next;
			else
				bool = false;

			return bool;
		}
	}

	/*
	 * alternate solution using array
	 */
	public static boolean isPalindrome1(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode node = head;
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		int[] arr = new int[len];
		len = 0;
		while (node != null) {
			arr[len++] = node.val;
			node = node.next;
		}
		for (int i = 0; i < len / 2; i++) {
			if (arr[i] != arr[len - i - 1])
				return false;
		}
		return true;
	}
}