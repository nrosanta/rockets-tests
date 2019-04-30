package com.testinfly.practice;

import java.util.Arrays;
import java.util.Comparator;

public class Sort2DMatrixbycolumn { 
	  
    // Function to sort by column 
    public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    } 
      
    // Driver Code 
    public static void main(String args[]) 
    { 
        int matrix[][] = { { 39, 27, 23, 67	 }, 
                           { 10, 93, 91, 90 }, 
                           { 54, 78, 56, 89 }, 
                           { 32, 64, 20, 65 } }; 
        // Sort this matrix by 3rd Column 
        int col = 3; 
        sortbyColumn(matrix, col - 1); 
        display(matrix);
        
        System.out.println();
        
        /*
        Arrays.sort(matrix, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
        	
        });
        */
        
        /*
         * Using lambda expression
         */
        Arrays.sort(matrix,(n1,n2)->n2[0]-n1[0]);
        display(matrix);
  

    } 
    
    public static void display(int[][] matrix) {
        // Display the sorted Matrix 
        for (int i = 0; i < matrix.length; i++) { 
            for (int j = 0; j < matrix[i].length; j++) 
                System.out.print(matrix[i][j] + " "); 
            System.out.println(); 
        } 
    }
} 