package com.prac.dp;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String X = "OldSite:GeeksforGeeks.org";
	    String Y = "NewSite:GeeksQuiz.com";
	    System.out.println("Length of Longest Common Substring is "+ LCSubStrDP(X, Y,X.length(),Y.length()));
	}

	public static int  LCSubStr(String x, String y, int m, int n) {
		// TODO Auto-generated method stub
	 if(m==0)
		 return 0;
	 if(n==0)
		 return 0;
	 if(x.charAt(m-1)==y.charAt(n-1)){
		 return 1+LCSubStr(x,y,m-1,n-1);
	 }
	 return max(LCSubStr(x,y,m-1,n),LCSubStr(x,y,m,n-1));
	}

	public static int  LCSubStrDP(String x, String y, int m, int n) {
		int dp[][]=new int[m+1][n+1];
		int length=-1;
		int end=-1;
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0)
					dp[i][j]=0;
				else{
					if(x.charAt(i-1)==y.charAt(j-1)){
						dp[i][j]=1+dp[i-1][j-1];
						if(dp[i][j]>length){
							end=i;
							length=dp[i][j];
						}
					}else{
						dp[i][j]=0;
					}
				}
				
			}
		}
		for(int i=end-length;i<end;i++){
			System.out.print(x.charAt(i));
		}
		System.out.println();
		return length;
	}
	private static int max(int a, int b) {
		// TODO Auto-generated method stub
		return (a>b)?a:b;
	}

}
