package com.testingfly.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversaltoList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		List<Integer> list = new ArrayList<>();
		int nodeCount = 0;
		while (!q.isEmpty()) {
			nodeCount = q.size();
			list = new ArrayList<Integer>();
			while (nodeCount > 0) {
				root = q.poll();
				list.add(root.val);
				if (root.left != null)
					q.add(root.left);
				if (root.right != null)
					q.add(root.right);
				nodeCount--;
			}
			res.add(list);
		}

		return res;
	}

	
	/*
	 * Using recursion
	 */
	
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        int height = getHeight(root,0);
        for(int i=1;i<=height;i++){
            res.add(levelOrder(root, i, new ArrayList<Integer>()));
        }
        return res;
    }
    
    public List<Integer> levelOrder(TreeNode root, int height, List<Integer> list) {
        if(root==null) return null;
        if(height==1)
            list.add(root.val);
        else{
            levelOrder(root.left,height-1, list);
            levelOrder(root.right,height-1, list);
        }
         return list; 
    }
    
    public int getHeight(TreeNode root, int height){
        TreeNode head = root;
        if(head==null) return 0;
        return Math.max(getHeight(head.left, height)+1,getHeight(head.right, height)+1);
    }
    
}