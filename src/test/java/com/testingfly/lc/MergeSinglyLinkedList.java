package com.testingfly.lc;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeSinglyLinkedList {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode head  = temp;
        while(l1!=null || l2!=null){
            if(l1==null){
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            else
            if(l2==null){
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else
            if(l1.val<l2.val){
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                temp.next = new ListNode(l2.val);
                l2 = l2.next;    
            }
            
            
            temp = temp.next;
        }
        
        return head.next;

    }
    
    
    /*
     * alternate recursive solution
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    	
    	if(l1==null && l2==null)
    		return null;
    	else if(l1==null)
    		return l2;
    	else if(l2==null)
    		return l1;
    	else if(l1.val < l2.val) {
    		l1.next = mergeTwoLists(l1.next, l2);
    		return l1;}
    	else{
    		l2.next = mergeTwoLists(l2.next, l1);
    		return l2;
    	}
    	
    }
    	   
    	
}