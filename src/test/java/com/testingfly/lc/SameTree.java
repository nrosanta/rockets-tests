package com.testingfly.lc;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {



/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p==null && q==null) return true;
        else if (p==null || q==null || p.val!=q.val) return false;
    
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        
        q1.add(p);
        q2.add(q);
        
        while(!q1.isEmpty() && !q2.isEmpty()){
            p = q1.poll();
            q = q2.poll();
            if(p.val != q.val)
                return false;
            if(p.left!=null && q.left!=null){
                q1.add(p.left);
                q2.add(q.left);
            } else if(p.left!=null || q.left!=null)
                return false;
            
            if(p.right!=null && q.right!=null){
                q1.add(p.right);
                q2.add(q.right);
            } else if(p.right!=null || q.right!=null)
                return false;
            
        }
        
        return true;
    }
}