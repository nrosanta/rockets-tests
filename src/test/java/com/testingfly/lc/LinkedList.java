package com.testingfly.lc;

public class LinkedList {

	public static void main(String[] args) {
		ListNode l1 = createLL(new int[] {9});
		ListNode l2 = createLL(new int[] {1,9,9,9,9,9,9,9,9,9});
		
		ListNode l3 = createLL(new int[] {2,5,5});
		ListNode l4 = createLL(new int[] {2,5,6});
		
		ListNode l5 = createLL(new int[] {2, 5, 5});
		ListNode l6 = createLL(new int[] {2, 5, 6});
		
		
		readLinkedList(l1);
		readLinkedList(l2);
		ListNode node1 = Solution.addTwoNumbers(l1,l2);
		readLinkedList(node1);
		
		readLinkedList(l3);
		readLinkedList(l4);
		ListNode node2 = Solution.addTwoNumbers(l3,l4);
		readLinkedList(node2);
		
		readLinkedList(l5);
		readLinkedList(l6);
		ListNode node3 = Solution.addTwoNumbersLC(l5,l6);
		readLinkedList(node3);
		

	}
	

	
	public static ListNode createLL(int nums[]) {
		ListNode list = new ListNode(nums[0]);
		ListNode temp = list;
		for(int i=1;i<nums.length;i++) {
			list.next = new ListNode(nums[i]);
			list = list.next;
		}
		
		return temp;
	}
	
  	public static void readLinkedList(ListNode node) {
		while(node!=null) {
			System.out.print(node.val);
			node=node.next;
		}
		System.out.println("\n");
		
	}

}

 
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      

  }
 
class Solution {
/*
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1="", s2="";
        while(l1!=null){
            s1 = s1+l1.val;
            l1 = l1.next;
        }
        while(l2!=null){
            s2 = s2+l2.val;
            l2 = l2.next;
        }
        int num = Integer.parseInt(new StringBuilder(s1).reverse().toString()) + Integer.parseInt(new StringBuilder(s2).reverse().toString());
        
        String str = Integer.toString(num);
        System.out.println(str);
        ListNode node = new ListNode(Character.getNumericValue(str.charAt(str.length()-1)));
        ListNode temp = node;

        for(int i=str.length()-2;i>=0;i--){
            node.next = new ListNode(Character.getNumericValue(str.charAt(i)));
            node = node.next;
        }
        
        return temp;
        
    }*/
	
    public static ListNode addTwoNumbersOld(ListNode l1, ListNode l2) {
    	int num1=0, num2=0;
    	
    	while(l1!=null) {
    		num1=num1*10+l1.val;
    		l1 = l1.next;
    	}
    	
    	while(l2!=null) {
    		num2=num2*10+l2.val;
    		l2 = l2.next;
    	}
    	
    	int total = num1+num2;
    	System.out.println("total: "+reverseInt(num2));
    	return null;
    }
    
    /**
		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
		Output: 7 -> 0 -> 8
		Explanation: 342 + 465 = 807.
     */
    
    public static int reverseInt(int nums) {
    	System.out.println("nums: "+nums);
    	int temp=0;
    	int rem=nums;
    	while(rem>0) {
    		rem=nums%10;
    		nums = nums/10;
    		temp = temp*10+rem;
    		System.out.println("rem: "+rem);
    		System.out.println("temp: "+temp);
    		
    	}
		return temp;
    	
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode temp = new ListNode(0);
    	ListNode node = temp;
		int num1=0, num2=0;
		int carry=0;
		
    	while(l1!=null || l2!=null) {
    		if(l1!=null) {
    			num1=l1.val;
    			l1=l1.next;
    		}else {
    			num1=0;
    		}
    		
    		if(l2!=null) {
    			num2=l2.val;
    			l2=l2.next;
    		}else {
    			num2=0;
    		}
    		
    		int val;
    		if((num1+num2+carry)>9) {
    			val = (num1+num2+carry)-10;
    			//System.out.println("num1: "+num1+" num2: "+num2+" total: "+(num1+num2+carry));
    			//System.out.println("rem: "+rem+" carry: "+carry);
    			carry=1;    			
    		}else {
    			val = num1+num2+carry;
    			carry=0;
    			//System.out.println("val2: "+val+" carry: "+carry);
    		}
    		
    		temp.next = new ListNode(val);
    		temp = temp.next;
    	}
    	if(carry==1)
    		temp.next = new ListNode(carry);
    	
    	return node.next;
    } 
    
    public static ListNode addTwoNumbersLC(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}