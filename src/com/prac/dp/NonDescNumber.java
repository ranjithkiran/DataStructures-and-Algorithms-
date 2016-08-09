package com.prac.dp;

public class NonDescNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    int n = 3;
		    System.out.println(countNonDecreasing(0,n));
		}

	public static int countNonDecreasing(int start, int n) {
		// TODO Auto-generated method stub
		if(n<=0)
			return 1;
		int ans=0;
		for(int i=0;i<=9;i++){
			if(i>=start){
				ans+=countNonDecreasing(i,n-1);
			}
		}
		return ans;
	}
}
