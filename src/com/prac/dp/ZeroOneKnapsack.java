package com.prac.dp;

public class ZeroOneKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
	    System.out.println("value is"+knapSack(wt, val,val.length,W ));
	    System.out.println("value is"+knapSackRec(wt, val,val.length,W ));
	}

	public static int knapSackRec(int[] wt, int[] val, int length, int W) {
		// TODO Auto-generated method stub
		if(W==0|| length==0)
			return 0;
		if(wt[length-1]<=W)
			 return max(knapSackRec(wt,val,length-1,W),val[length-1]+knapSackRec(wt,val,length-1,W-wt[length-1]));
	    else
			return 	 knapSackRec(wt,val,length-1,W);
	}

	public static int knapSack(int[] wt, int[] val, int length, int w) {
		// TODO Auto-generated method stub
		int dp[][]=new int[val.length+1][w+1];
		for(int i=0;i<=val.length;i++){
			dp[i][0]=0;
		}
		for(int i=1;i<=w;i++){
			dp[0][i]=0;
		}
		for(int i=1;i<=wt.length;i++){
			for(int j=1;j<=w;j++){
				if(wt[i-1]<=j){
					dp[i][j]=max(dp[i-1][j-wt[i-1]]+val[i-1],dp[i-1][j]);
				}else{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		
		return dp[val.length][w];
	}

	public static int max(int a, int b) {
		// TODO Auto-generated method stub
		if(a>b)
			return a;
		else
			return b;
	}

}
