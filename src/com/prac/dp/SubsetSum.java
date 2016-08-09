package com.prac.dp;

public class SubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int set[] = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		if (isSubsetSumDP(set, set.length, sum) == true)
		     System.out.println("Found a subset with given sum");
		  else
		     System.out.println("No subset with given sum");
	}

	public static boolean isSubsetSum(int[] set, int length, int sum) {
		// TODO Auto-generated method stub
		if(sum==0)
			return true;
		if(sum!=0 && length==0)
			return false;
		if(set[length-1]<=sum)
			return isSubsetSum(set, length-1, sum-set[length-1])|| isSubsetSum(set,length-1,sum);
		else
			return isSubsetSum(set,length-1,sum);
	}
	
	public static boolean isSubsetSumDP(int[] set, int length, int sum) {
		boolean dp[][]=new boolean[length+1][sum+1];
		for(int i=0;i<=length;i++){
			dp[i][0]=true;
		}
		for(int i=1;i<=sum;i++){
			dp[0][i]=false;
		}
		
		for(int i=1;i<=length;i++){
			for(int j=1;j<=sum;j++){
				if(set[i-1]>j)
					dp[i][j]=dp[i-1][j];
				else
					dp[i][j]=dp[i-1][j] || dp[i][j-set[i-1]];
					
			}
		}
		return dp[length][sum];
	}

}
