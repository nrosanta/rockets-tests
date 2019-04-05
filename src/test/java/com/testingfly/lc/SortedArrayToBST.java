package com.testingfly.lc;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return doBST(nums, 0, nums.length-1);
    }
    
    /*
     * recursive solution
     */
    public TreeNode doBST(int[] nums, int left, int right){
        if(left>right) return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = doBST(nums, left, mid-1); 
        root.right = doBST(nums, mid+1, right);
        return root;
    }
}