package com.prac.dp;

public class MinJumps {
	public static void  main(String args[])
	{
	    int arr[] = {1, 3, 6, 1, 0, 9};
	     System.out.println("Minimum number of jumps to reach end is %d "+minJumps(arr,arr.length));
	}

	public static int minJumps(int[] arr, int length) {
		// TODO Auto-generated method stub
		int dp[]=new int[length];
		dp[0]=0;
		for(int i=1;i<length;i++){
			dp[i]=Integer.MAX_VALUE;
			for(int j=0;j<i;j++){
				if(i<=j+arr[j] && dp[j]!=Integer.MAX_VALUE){
					dp[i]=min(dp[i],dp[j]+1);
					break;
				}
			}
		}
		return dp[length-1];
	}

	private static int min(int i, int j) {
		// TODO Auto-generated method stub
		if(i<j)
			return i;
		else
			return j;
	}
}
