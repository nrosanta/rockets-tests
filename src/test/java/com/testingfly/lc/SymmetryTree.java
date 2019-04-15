package com.testingfly.lc;

import java.util.LinkedList;
import java.util.Queue;
/*
 * public class TreeNode {

	int val;
	TreeNode left, right;

	TreeNode(int data) {
		this.val = data;
		this.left = null;
		this.right = null;

	}
 */

public class SymmetryTree {
	public static void main(String args[]) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(2);
		t.left.left = null;
		t.left.right = new TreeNode(3);
		t.right.left = null;
		t.right.right = new TreeNode(3);
		t.inOrder(t);
		System.out.println(isSymmetric(t));
		
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		t2.right = new TreeNode(2);
		t2.left.left = new TreeNode(3);;
		t2.left.right = new TreeNode(4);
		t2.right.left = new TreeNode(4);;
		t2.right.right = new TreeNode(3);
		t2.inOrder(t);
		System.out.println(isSymmetric(t2));
	}

	public static boolean isSymmetric1(TreeNode root) {
		return checkSymmetry(root, root);
	}
	
	
	/*
	 * solution using iterative approach
	 */
	public static boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode t1 = q.poll();
			TreeNode t2 = q.poll();
			
			if(t1==null && t2==null)continue;
				
			if(t1==null || t2==null)return false;
				
			if(t1.val!=t2.val) return false;
			
			q.add(t1.left);
			q.add(t2.right);
			
			q.add(t1.right);
			q.add(t2.left);
		}
		
		return true;
	}


	
	
	/*
	 * alternate recursive solution
	 */
	public static boolean checkSymmetry(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null)
            return true;
        else
            if(t1==null || t2==null)
                return false;
        return (t1.val == t2.val && checkSymmetry(t1.left, t2.right) && checkSymmetry(t1.right, t2.left));
    }


}