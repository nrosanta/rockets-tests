package com.testingfly.lc;

public class FindComplement {

	/*
	 * Approach using bitwise left shift and XOR operations
	 */
    public int findComplement(int num) {
        int i=0;
        int res = num;
        while(num>0){
            num=num/2;
            res = (res ^ (1<<i));
            //System.out.println(res);
            i++;
        }
        
        return res;
        
    }
    
    /*
     * Alternative approach using StringBuilder and XOR operations
     */
    public int findComplement1(int num) {
        StringBuilder sb = new StringBuilder();
        while(num>0){
            int rem = num%2;
            sb.append(rem ^ 1);
            num = num/2;
        }
        return Integer.parseInt(sb.reverse().toString(),2);
    }
}