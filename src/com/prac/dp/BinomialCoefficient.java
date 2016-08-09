package com.prac.dp;

public class BinomialCoefficient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5, k = 2;
	    System.out.println("Value of C(%d, %d) is %d "+ binomialCoeffDP(n, k));
	}

	public static int binomialCoeffRec(int n, int k) {
		// TODO Auto-generated method stub
		if(k==0 || k==n)
			return 1;
		else
			return binomialCoeffRec(n-1,k-1)+binomialCoeffRec(n-1,k);
	}
	
	public static int binomialCoeffDP(int n,int k){
		int dp[][]=new int[n+1][k+1];
		for(int i=0;i<=k;i++){
			dp[0][i]=0;
		}
		for(int i=1;i<=n;i++){
			dp[i][0]=1;
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=k;j++){
				if(i==j)
					dp[i][j]=1;
				else
					dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
			}
		}
		return dp[n][k];
	}

}
