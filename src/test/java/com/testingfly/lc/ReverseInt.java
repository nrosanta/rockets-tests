package com.testingfly.lc;


class ReverseInt {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int reverse(int x) {
        long rev = 0;
        int num = Math.abs(x);
        while(num>0){
            rev = rev*10 + num%10;
            if(rev>Integer.MAX_VALUE && x>0) return 0;
            if(-rev<Integer.MIN_VALUE && x<0) return 0;
            num = num/10;
        }
        return x<0?-(int)rev:(int)rev;
    }
}