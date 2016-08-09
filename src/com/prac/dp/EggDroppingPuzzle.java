package com.prac.dp;

public class EggDroppingPuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2, k = 36;
	     System.out.println("\nMinimum number of trials in worst case with %d eggs and %d floors is %d \n"+eggDropDP(n, k));
	}
	
	public static int eggDropDP(int n,int k){
		int dp[][]=new int[n+1][k+1];
		for(int i=0;i<=k;i++){
			dp[0][i]=0;
		}
		for(int i=1;i<=n;i++){
			dp[i][0]=0;
			dp[i][1]=1;
		}
		for(int i=1;i<=k;i++){
			dp[1][i]=i;
		}
		int res=0;
		for(int i=2;i<=n;i++){
			for(int j=2;j<=k;j++){
				dp[i][j]=Integer.MAX_VALUE;
				for(int x=1;x<=j;x++){
					  res=1+max1(dp[i-1][x-1],dp[i][j-x]);
					  if(res<dp[i][j]){
						  dp[i][j]=res;;
					  }
				}
			}
		}
		return dp[n][k];
	}

	private static int max1(int a, int b) {
		// TODO Auto-generated method stub
		if(a<b)
			return b;
		else
			return a;
	}

	public static int eggDrop(int n, int k) {
		// TODO Auto-generated method stub
		if(k==0 || k==1)
			return k;
		if(n==1)
			return k;
		int min=Integer.MAX_VALUE,x,res;
		for(x=1;x<=k;x++){
			res=max1(eggDrop(n-1,x-1),eggDrop(n,k-x));
			if(res<min)
				min=res;
		}
	return 1+min;
	}

	public static int max(int a, int b) {
		// TODO Auto-generated method stub
		if(a<b)
			return b;
		else
			return a;
	}

}
