package com.prac.array;

public class ClosestPair2Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar1[] = {1, 4, 5, 7};
        int ar2[] = {10, 20, 30, 40};
        int m = ar1.length;
        int n = ar2.length;
        int x = 38;
        printClosest(ar1, ar2, m-1, n-1, x);
	}

	private static void printClosest(int[] ar1, int[] ar2, int m, int n, int x) {
		// TODO Auto-generated method stub
		int first=0;int max_diff=Integer.MAX_VALUE;
		int firstvalue=0;
		int secondvalue=0;
		while(first<=m && n>=0){
			if(max_diff>Math.abs((ar1[first]+ar2[n])-x)){
					max_diff=Math.abs((ar1[first]+ar2[n])-x);
					firstvalue=ar1[first];
					secondvalue=ar2[n];
					n--;
				}
			  if((ar1[first]+ar2[n])>x){
				 n--;
			  }
			else 
				first++;
			
		}
		System.out.println("values are"+firstvalue+"second value"+secondvalue);
	}

}
