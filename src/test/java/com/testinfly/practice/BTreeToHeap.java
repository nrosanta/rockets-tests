package com.testinfly.practice;

import java.util.Stack;

class BTree {
	int data;
	BTree left;
	BTree right;

	BTree(int data) {
		this.data = data;
	}
}

public class BTreeToHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public BTree toHeap(BTree root) {
		Stack<BTree> stk = new Stack<>();
		while (root != null || !stk.isEmpty()) {
			while (root != null) {
				stk.push(root);
				root = root.right; //4,6,7
			}
			root = stk.pop(); //7, 6
			
			heapify(root); 

			if (root.left != null)
				root = root.left; //6

		}

		return null;
	}
	
	BTree heapify(BTree root) {
		if(root.right!=null && root.right.data<root.data) {
			swap(root, root.right);
		}
		
		if(root.left!=null && root.left.data<root.data) {
			swap(root, root.left);
		}
		
		return root;

	}
	
	BTree swap(BTree root, BTree child) {
		if(root!=null && child!=null) {
			int temp = root.data;
			root.data = child.data;
			child.data = temp;
		}
		return root;
	}

}
