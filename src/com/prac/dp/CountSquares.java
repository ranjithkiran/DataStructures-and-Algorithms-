package com.prac.dp;

public class CountSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={3,5,10};
		int n = 20;
	    System.out.println("Count for 20d is %d"+count(n,arr));
	 
	    n = 13;
	    System.out.println("Count for 13d is %d"+ count(n,arr));
	}
	public static int count(int n,int arr[])
	{
	    // table[i] will store count of solutions for
	    // value i.
	    if(n<=2)
	    	return 0;
	    if(n==3)
	    	return 1;
	    // One by one consider given 3 moves and update the table[]
	    // values after the index greater than or equal to the
	    // value of the picked move
	    int ans=0;
	    for(int i=0;i<arr.length;i++){
	    	ans+=count(n-arr[i],arr);
	    }
	     return ans;
	}
	
}
