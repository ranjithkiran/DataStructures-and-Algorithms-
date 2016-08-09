package com.prac.dp;

public class palindromepartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aaaaaaaaaaaaaa";
		   System.out.println("Min cuts needed for Palindrome Partitioning is %d"+minPalPartion(str));
	}

	public static int minPalPartion(String str) {
		// TODO Auto-generated method stub
		boolean dp[][]=new boolean[str.length()][str.length()];
		int c[][]=new int[str.length()][str.length()];
		for(int i=0;i<str.length();i++){
			dp[i][i]=true;
		}
		for(int l=2;l<=str.length();l++){
			for(int i=0;i<str.length()-l+1;i++){
				int j=i+l-1;
				if(l==2)
					dp[i][j]=str.charAt(i)==str.charAt(j);
				else
				dp[i][j]=(str.charAt(i)==str.charAt(j)) && dp[i+1][j-1];
				
				if(dp[i][j]==true)
					c[i][j]=0;
				else{
					c[i][j]=Integer.MAX_VALUE;
					for(int k=i;k<=j-1;k++){
						c[i][j]=min(c[i][j],1+c[i][k]+c[k+1][j]);
					}
				}
			}
		}
		return c[0][str.length()-1];
	}

	public static int min(int i, int j) {
		// TODO Auto-generated method stub
		if(i<j)
			return i;
		else
			return j;
	}

}
