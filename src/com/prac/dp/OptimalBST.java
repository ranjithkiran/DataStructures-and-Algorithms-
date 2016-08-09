package com.prac.dp;

public class OptimalBST {

	public static void main(String[] args)
	{
	    int keys[] = {10, 12, 20};
	    int freq[] = {34, 8, 50};
	    System.out.println("Cost of Optimal BST is %d "+optimalSearchTreeDP(freq,keys.length-1));
	    //optimalSearchTreeDP(freq,keys.length);
	}

	private static int optimalSearchTreeDP(int[] freq, int length) {
		// TODO Auto-generated method stub
	 int cost[][]=new int[length][length];
	 for(int i=0;i<length;i++){
		 cost[i][i]=0;
	 }
	 
	 for(int l=2;l<=length;l++){
		 for(int i=0;i<length-l+1;i++){
			 int j=i+length-1;
			 cost[i][j]=Integer.MAX_VALUE;
		   for(int r=i;r<=j;r++){
				 int c=((r>i)?cost[i][r-1]:0)+((r<j)?cost[r+1][j]:0)+sumfreq(freq, i, j);
				 if(c<cost[i][j])
					 cost[i][j]=c;
			 }
			 
		 }
	 }
	return  cost[0][length-1];
	}

	public static int optimalSearchTree(int[] freq, int start,int end) {
		// TODO Auto-generated method stub
        if(start>end)
        	return 0;
        if(start==end)
        	return freq[start];
        int sum=sumfreq(freq,start,end);
        int min=Integer.MAX_VALUE;
        for(int r=start;r<=end;r++){
        	int cost=optimalSearchTree(freq, start, r-1)+optimalSearchTree(freq, r+1, end);
        	if(cost<min)
        		min=cost;
        }
        return min+sum;
	}

	public static int sumfreq(int[] freq, int start, int end) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=start;i<=end;i++){
			sum+=freq[i];
		}
		return sum;
	}

}
