package com.testingfly.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javafx.util.Pair;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class BtreeInOrderTraversal {

	public static void main(String[] args) {

	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		return inorderTraversal(root, list);
	}

	/*
	 * recursive solution
	 */
	public List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
		if (root == null)
			return list;
		inorderTraversal(root.left, list);
		list.add(root.val);
		inorderTraversal(root.right, list);
		return list;
	}

	/*
	 * Using stacks
	 */
	public List<Integer> inorderTraversal1(TreeNode root) {
		if (root == null)
			return new ArrayList<Integer>();
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stk = new Stack<>();
		TreeNode curr = root;
		while (curr != null || stk.size() > 0) {
			while (curr != null) {
				stk.push(curr);
				curr = curr.left;
			}

			curr = stk.pop();
			list.add(curr.val);
			curr = curr.right;

		}

		return list;
	}

	/*
	 * Using Pair
	 */
	public List<Integer> inorderTraversalIterative2(TreeNode root) {
		if (root == null)
			return new ArrayList<Integer>();
		Stack<Pair<TreeNode, Boolean>> s = new Stack<Pair<TreeNode, Boolean>>(); // Boolean is to mark if the left side
																					// was already visited
		s.add(new Pair(root, false));
		List<Integer> lst = new ArrayList<Integer>();
		while (!s.empty()) {
			Pair<TreeNode, Boolean> curr = s.pop();
			if (curr.getKey().left != null && !curr.getValue()) {
				s.push(new Pair(curr.getKey(), true));
				s.push(new Pair(curr.getKey().left, false));
			} else {
				lst.add(curr.getKey().val);
				if (curr.getKey().right != null) {
					s.push(new Pair(curr.getKey().right, false));
				}
			}
		}
		return lst;
	}

}