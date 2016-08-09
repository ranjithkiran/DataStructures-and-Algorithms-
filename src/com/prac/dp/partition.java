package com.prac.dp;

public class partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 1, 5, 9, 12};
		if (findPartiion(arr, arr.length) == true)
		     System.out.println("Can be divided into two subsets of equal sum");
		  else
		     System.out.println("Can not be divided into two subsets of equal sum");
	}

	public static boolean findPartiion(int[] arr, int length) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0;i<arr.length;i++){
			sum=sum+arr[i];
		}
		if(sum%2!=0)
			return false;
		return  isSubsetSumDP (arr, arr.length, sum/2);
	}

	public static boolean isSubsetSum(int[] arr, int length, int sum) {
		// TODO Auto-generated method stub
		if(sum==0)
			return true;
		if(sum!=0 && length==0)
			return false;
		if(arr[length-1]>sum){
			return isSubsetSum(arr,length-1,sum);
		}
		return isSubsetSum(arr,length-1,sum-arr[length-1]) || isSubsetSum(arr,length-1,sum);
	}
	
	public static boolean isSubsetSumDP(int[] arr, int length, int sum) {
		boolean dp[][]=new boolean[sum+1][arr.length+1];
		for(int i=0;i<=arr.length;i++){
			dp[0][i]=true;
		}
		for(int i=1;i<=sum;i++){
			dp[i][0]=false;
		}
		for(int i=1;i<=sum;i++){
			for(int j=1;j<=arr.length;j++){
				if(arr[j-1]>i)
					dp[i][j]=dp[i][j-1];
				else{
					dp[i][j]=dp[i][j-1] || dp[i-arr[j-1]][j-1];
				}
					
			}
		}
		return dp[sum][arr.length];
	}

}
