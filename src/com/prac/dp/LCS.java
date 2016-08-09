package com.prac.dp;

public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String X = "AGGTAB";
		String	Y = "GXTXAYB";
		//StringBuilder temp=new StringBuilder("");
		//System.out.println("Length of LCS is "+lcs(X , Y, X.length(), Y.length(),temp));
		//System.out.println("temp string is"+temp);
		System.out.println("lcs value is"+lcsDP(X,Y,X.length(),Y.length()));
	}

	public static int lcsDP(String x, String y, int m, int n) {
		// TODO Auto-generated method stub
		int[][] LCS=new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			LCS[i][0]=0;
		}
		for(int i=0;i<=n;i++){
			LCS[0][i]=0;
		}
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(x.charAt(i-1)==y.charAt(j-1))
					LCS[i][j]=1+LCS[i-1][j-1];
				else
					LCS[i][j]=max(LCS[i][j-1],LCS[i-1][j]);
				
			}
		}
		return  LCS[m][n];
	}

	public static int lcs(String x, String y, int m, int n,StringBuilder temp) {
		// TODO Auto-generated method stub
		
		if(m==0 || n==0)
			return 0;
		
		if(x.charAt(m-1)==y.charAt(n-1)){
			temp.append(x.charAt(m-1));
			return 1+lcs(x,y,m-1,n-1,temp);
	    }
		else{
			int maxone=lcs(x,y,m-1,n,temp);
			int maxtwo=lcs(x,y,m,n-1,temp);
			return max(maxone,maxtwo);
		}
			
	}

	public static int max(int a, int b) {
		// TODO Auto-generated method stub
		if(a>b)
			return a;
		else
			return b;
	
	}

}
