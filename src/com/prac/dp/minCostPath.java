package com.prac.dp;

public class minCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cost[][] = { {1, 2, 3},{4, 8, 2},{1, 5, 3} };
		System.out.println("value is"+ minCost(cost, 2, 2));
		System.out.println("dp value is"+ minCostDP(cost, 2, 2));
	}
	
	public static int min(int a,int b ,int c){
		if(a<b && a<c)
			return a;
		else if(b<c)
			return b;
		else
		return c;
			
	}

	public static int minCost(int[][] cost, int i, int j) {
		// TODO Auto-generated method stub
		if(i==0 && j==0)
			return cost[i][j];
		if(i<0)
			return Integer.MAX_VALUE;
		if(j<0)
			return Integer.MAX_VALUE;
	    return cost[i][j]+min(minCost(cost,i-1,j-1),minCost(cost,i,j-1),minCost(cost,i-1,j));
	}
	public static int minCostDP(int[][] cost, int m, int n) {
		// TODO Auto-generated method stub
		int tc[][]=new int[m+1][n+1];
		tc[0][0]=cost[0][0];
		for(int i=1;i<=m;i++){
			tc[0][i]=tc[0][i-1]+cost[0][i];
		}
		for(int j=1;j<=n;j++){
			tc[j][0]=tc[j-1][0]+cost[j][0];
		}
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				tc[i][j]=cost[i][j]+min(tc[i-1][j-1],tc[i-1][j],tc[i][j-1]);
			}
		}
		return tc[m][n];
	}

}
