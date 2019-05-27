package com.testinfly.practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class CountDistinctMax { 
    // function to find maximum distinct elements  
    // after removing k elements  
    static int maxDistinctNum(int[] arr, int n, int k) 
    { 
           // hash map to store  
           // frequency of each element  
           HashMap<Integer, Integer> map = new HashMap<>(); 

           // priority_queue 'pq' implemented as  
           // max heap  
           PriorityQueue<Integer> pq =  
                       new PriorityQueue<>(Collections.reverseOrder()); 
             
           // storing frequency of each element in map 
           for (int i = 0; i < n; i++) { 
                if(map.containsKey(arr[i])) { 
                     int val = map.get(arr[i]); 
                     val++; 
                     map.remove(arr[i]); 
                     map.put(arr[i], val); 
                  } 

                else  
                    map.put(arr[i], 1); 
           } 

           // inserting frequency of each element in 'pq' 
           for (Map.Entry<Integer, Integer> entry : map.entrySet()) { 
                pq.add(entry.getValue()); 
           } 
           
           

           while (k > 0) { 
        	   System.out.println(pq);
                 // get the top element of 'pq' 
                 int temp = pq.poll(); 

                 // decrement the popped element by 1  
                 temp--;  

                 // if true, then push the element in 'pq' 
                 if (temp > 0) 
                     pq.add(temp); 
                 k--; 
           }  
           
           System.out.println(pq);

           // Count all those elements that appear  
           // once after above operations.  
//           int res = 0; 
//           while (pq.size() != 0) { 
//                 pq.poll(); 
//                 res++; 
//           } 

           return pq.size(); 
    } 

    // Driver code 
    public static void main(String args[]) 
    { 
           //int[] arr = { 5, 7, 5, 5, 1, 2, 2 }; 
           //int[] arr = {80, 80, 1000000000, 80, 80, 80, 80, 80, 80, 123456789}; //3
           //int[] arr = {2,2,2,3,3,3,4,4,4,5,5,5};//4
           int[] arr = {3, 4, 7, 7, 6, 6};  //3
           int n = arr.length; 
           int k = n/2; 
           System.out.println("Maximum distinct elements = " +  
                              maxDistinctNum(arr, n, k)); 
    } 
}  