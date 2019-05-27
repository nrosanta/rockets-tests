package com.testingfly.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementinBST {
	
	KthSmallestElementinBST(){
		System.out.println("Hello World!");
	}

	/*
	 * Recursive approach using list
	 */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<Integer>();
        return helperKthSmallest(root, list).get(k-1);
    }
    
    List<Integer> helperKthSmallest(TreeNode root, List<Integer> list){
        if(root==null) return null;
        helperKthSmallest(root.left,list);
        list.add(root.val);
        helperKthSmallest(root.right,list);
        return list;
    }
    
	/*
	 * Recursive approach using extra variable
	 */
    public int kthSmallest1(TreeNode root, int k) {
    	int[] x= new int[] {0};
        return helperKthSmallest1(root, x, k).val;
    }
    
    TreeNode helperKthSmallest1(TreeNode root, int[] x, int k){
        if(root==null) return null;
        TreeNode left = helperKthSmallest1(root.left,x, k);
        if(++x[0]==k)
        	return root;
        if(left!=null)
        	return left;
        else
        	return helperKthSmallest1(root.right,x, k);
        
    }
    
    /*
     * Using stack
     */
    public int kthSmallest2(TreeNode root, int k) {
    	Stack<TreeNode> stk = new Stack<>();
    	while(root!=null || !stk.isEmpty()) {
	    	while(root!=null) {
	    		stk.push(root);
	    		root=root.left;
	    	}
	    	k--;
	    	root = stk.pop();
	    	if(k==0)
	    		break;
	    	root = root.right;
    	}
    	return root.val;
    }
    
    
    /*
     * Using custom object as counter
     */
    
    class Solution {
        class Counter{
            int x;
            Counter(int x){
                this.x=x;
            }
        }
        public int kthSmallest(TreeNode root, int k) {
        	int x = 0;//new int[]{0};
            Counter count = new Counter(0);
            return helperKthSmallest(root, count, k).val;
        }
        
        TreeNode helperKthSmallest(TreeNode root, Counter count, int k){
            if(root==null) return null;
            TreeNode left = helperKthSmallest(root.left,count, k);
            //System.out.println(Arrays.toString(x));
            System.out.println(count.x);
            if(++count.x==k)
            	return root;
            if(left!=null)
            	return left;
            else
            	return helperKthSmallest(root.right,count, k);
        }
        
    }
    
    
}

/*
 * Using array object to track counter
 */
class Solution2 {
    
    public int kthSmallest(TreeNode root, int k) {
        int[] counter = {0};
        return helperKthSmallest(root, counter, k).val;
        
    }
    
    TreeNode helperKthSmallest(TreeNode root, int[] counter, int k){
        if(root==null) return null ;
        TreeNode left = helperKthSmallest(root.left, counter, k);
        counter[0]++;
        if(counter[0]==k) return root;
        if(left!=null) return left;
        return helperKthSmallest(root.right, counter, k);
       
    }
    
    /*
     * Kth Largest using reversed In-Order traversal
     */
    TreeNode helperKthLargest(TreeNode root, int[] counter, int k){
        if(root==null) return null ;
        TreeNode right = helperKthLargest(root.right, counter, k);
        counter[0]++;
        if(counter[0]==k) return root;
        if(right!=null) return right;
        return helperKthLargest(root.left, counter, k);
       
    }
    
    
}


