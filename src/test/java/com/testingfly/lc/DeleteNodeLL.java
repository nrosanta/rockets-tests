package com.testingfly.lc;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class DeleteNodeLL {
    public void deleteNode1(ListNode node) {
        while(node.next!=null){
            int temp = node.next.val;
            node.val = temp;
            if(node.next.next==null){
                node.next=null;
                break;
            }
            node=node.next;
        }
        
    }
    
    /*
     * alternate solution
     */
    public void deleteNode2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
        
    }
}