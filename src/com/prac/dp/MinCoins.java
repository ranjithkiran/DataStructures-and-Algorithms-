package com.prac.dp;

public class MinCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] =  {9, 6, 5, 1};
	    int V = 20;
	    int length=coins.length;
	    System.out.println("Minimum coins required is"+minCoinsDP(coins, length, V));
	}

	public static int minCoins(int[] coins, int length, int v) {
		// TODO Auto-generated method stub
		if(v==0)
			return 0;
		int res=Integer.MAX_VALUE;
		for(int i=0;i<coins.length;i++){
			if(coins[i]<=v){
				res=min(res,1+minCoins(coins,length,v-coins[i]));
			}
		}
		return res;
	}
   
	public static int minCoinsDP(int[] coins, int length, int v) {
		int dp[]=new int[v+1];
		dp[0]=0;
		for(int i=1;i<=v;i++){
			dp[i]=v;
			for(int j=0;j<length;j++){
				if(coins[j]<=i){
					dp[i]=min(dp[i],1+dp[i-coins[j]]);
				}
			}
		}
		return dp[v];
	}
	public static int min(int a, int b) {
		// TODO Auto-generated method stub
		return (a<b)?a:b;
	}

}
