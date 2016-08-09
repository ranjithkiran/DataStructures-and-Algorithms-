package com.prac.dp;

public class LPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String seq = "GEEKSFORGEEKS";
	    System.out.println("The length of the LPS is %d"+lpsDP(seq));
	}

	public static int lps(String seq, int i, int j) {
		// TODO Auto-generated method stub
		if(i==j)
			return 1;
		if(i+1==j && seq.charAt(i)==seq.charAt(j))
			return 2;
		if(seq.charAt(i)==seq.charAt(j))
			return 2+lps(seq,i+1,j-1);
		else{
			return max(lps(seq,i,j-1),lps(seq,i+1,j));
		}
	}
	
	public static int lpsDP(String seq) {
		// TODO Auto-generated method stub
		int length=seq.length();
		int dp[][]=new int[seq.length()][seq.length()];
		for(int i=0;i<length;i++){
			dp[i][i]=1;;
		}
		int j;
		for(int l=2;l<=length;l++){
			for(int i=0;i<length-l+1;i++){
				j=i+l-1;
				if(seq.charAt(i)==seq.charAt(j) && l==2){
					dp[i][j]=2;
				}
				else if(seq.charAt(i)==seq.charAt(j)){
					dp[i][j]=2+dp[i+1][j-1];
				}
				else{
					dp[i][j]=max(dp[i][j-1],dp[i+1][j]);
				}
		     }
		}
		return dp[0][length-1];
	}
	
	 public static int lpsgeeks(String seq)
	    {
	       int n = seq.length();
	       int i, j, cl;
	       int L[][] = new int[n][n];  // Create a table to store results of subproblems
	      
	       // Strings of length 1 are palindrome of lentgh 1
	       for (i = 0; i < n; i++)
	           L[i][i] = 1;
	              
	        // Build the table. Note that the lower diagonal values of table are
	        // useless and not filled in the process. The values are filled in a
	        // manner similar to Matrix Chain Multiplication DP solution (See
	        // http://www.geeksforgeeks.org/archives/15553). cl is length of
	        // substring
	        for (cl=2; cl<=n; cl++)
	        {
	            for (i=0; i<n-cl+1; i++)
	            {
	                j = i+cl-1;
	                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
	                   L[i][j] = 2;
	                else if (seq.charAt(i) == seq.charAt(j))
	                   L[i][j] = L[i+1][j-1] + 2;
	                else
	                   L[i][j] = max(L[i][j-1], L[i+1][j]);
	            }
	        }
	              
	        return L[0][n-1];
	    }
	      

	private static int max(int a, int b) {
		// TODO Auto-generated method stub
		if(a>b)
			return a;
		else
			return b;
	}
	

}
