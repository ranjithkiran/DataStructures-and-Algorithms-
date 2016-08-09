package com.prac.dp;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String str1 = "sunday";
		 String str2 = "saturday";
		 editDistDP(str1,str2,str1.length(),str2.length());
		 System.out.println(editDistDP(str1,str2,str1.length(),str2.length()));
	}

	public static int editDistDP(String str1, String str2, int m, int n) {
		// TODO Auto-generated method stub
		int dist[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			dist[i][0]=i;
		}
		for(int i=0;i<=n;i++){
			dist[0][i]=i;
		}
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(str1.charAt(i-1)==str2.charAt(j-1))
					dist[i][j]=dist[i-1][j-1];
				else{
					int rep=dist[i-1][j-1];
					int del=dist[i-1][j];
					int ins=dist[i][j-1];
					dist[i][j]=1+min(rep,del,ins);
				}
			}
		}
		return dist[m][n];
		
	}

	public static int editDist(String str1, String str2, int m, int n) {
		// TODO Auto-generated method stub
		   if(m==0)
			   return n;
		   if(n==0)
			   return m;
		   if(str1.charAt(m-1)==str2.charAt(n-1))
			   return editDist(str1,str2,m-1,n-1);
		   else{
			   int rep=editDist(str1,str2,m-1,n-1);
			   int del=editDist(str1,str2,m-1,n);
			   int ins=editDist(str1,str2,m,n-1);
			   return 1+min(rep,del,ins);
		   }
	}
	
	public static int min(int a,int b ,int c){
		if(a<b && a<c)
			return a;
		else if(b<c)
			return b;
		else
		return c;
			
	}

}
