package com.prac.dp;

public class sizeSubMartix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int M[][] =  {{0, 1, 1, 0, 1}, 
		                   {1, 1, 0, 1, 0}, 
		                   {0, 1, 1, 1, 0},
		                   {1, 1, 1, 1, 0},
		                   {1, 1, 1, 1, 1},
		                   {0, 0, 0, 0, 0}};
		                
		  printMaxSubSquare(M);
	}

	public static void printMaxSubSquare(int[][] m) {
		// TODO Auto-generated method stub
		int dp[][]=new int[m.length][m.length];
		for(int i=0;i<m[0].length;i++){
			dp[0][i]=m[0][i];
		}
		for(int j=0;j<m.length;j++){
			dp[j][0]=m[j][0];
		}
	
		for(int i=1;i<m.length;i++){
			for(int j=1;j<m[0].length;j++){
				if(m[i][j]==1){
					dp[i][j]=min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])+1;
				}else
					dp[i][j]=0;
			}
		}
		int max_val=dp[0][0];
		int max_row=0;
		int max_col=0;
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[0].length;j++){
				if(max_val<dp[i][j]){
					max_val=dp[i][j];
					max_row=i;
					max_col=j;
				}
					
			}
		}
		for(int i=max_row;i>max_row-max_val;i--){
			for(int j=max_col;j>max_col-max_val;j--){
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
	}

	public static int min(int i, int j, int k) {
		// TODO Auto-generated method stub
		if(i<j && i<k)
			return i;
		else if(j<k)
			return j;
		else
			return k;
	}

}
