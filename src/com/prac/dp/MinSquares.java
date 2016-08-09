package com.prac.dp;

public class MinSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMinSquares(25));
		}

	public static int getMinSquares(int n) {
		// TODO Auto-generated method stub
	     int dp[]=new int[n+1];
	     dp[0]=0;
	     dp[1]=1;
	     dp[2]=2;
	     dp[3]=3;
	     for(int i=4;i<=n;i++){
	    	 dp[i]=i;
	    	 for(int j=1;j*j<=i;j++){
	    		 dp[i]=min(dp[i],1+dp[i-j*j]);
	    	 }
	     }
	     return dp[n];
	}

	public static int min(int a, int b) {
		// TODO Auto-generated method stub
		return (a<b)?a:b;
	}
	}
