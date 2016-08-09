package com.prac.dp;

public class MinInsertionsPal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str= "geeks";
	    System.out.println("output is"+findMinInsetionsRec(str,0,str.length()-1));
	    System.out.println("output is"+findMinInsertions(str,str.length()-1));
	}
    
	public static int findMinInsetionsRec(String str,int start,int end){
		if(start>end)
			return Integer.MAX_VALUE;
		if(start==end)
			return 0;
		if(start+1==end){
			return (str.charAt(start)==str.charAt(end))?0:1;
		}
		return (str.charAt(start)==str.charAt(end))?findMinInsetionsRec(str,start+1,end-1):min(findMinInsetionsRec(str,start+1,end),findMinInsetionsRec(str,start,end-1))+1;
	}
	private static int min(int a, int b) {
		// TODO Auto-generated method stub
		return (a<b)?a:b;
	}

	public static int findMinInsertions(String str, int length) {
		// TODO Auto-generated method stub
		int dp[][]=new int[length][length];
		for(int i=0;i<length;i++){
			dp[i][i]=0;
		}
		for(int gap=1;gap<length;gap++){
			for(int i=0,j=gap;i<length&& j<length;i++,j++){
				   if(str.charAt(i)==str.charAt(j)){
						dp[i][j]=1+dp[i-1][j-1];
					}else{
						dp[i][j]=min(dp[i+1][j],dp[i][j-1])+1;
					}
				}
			}
		return dp[0][length-1];
		
	}

}
