package com.prac.dp;

public class CountWaysScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		System.out.println("Count for %d is %d\n"+ count(n));
		n = 13;
		System.out.println("Count for %d is %d"+ count(n));
	}
	
	// Returns number of ways to reach score n
	public static int count(int n)
	{
		// table[i] will store count of solutions for
		// value i.
		int table[]=new int[n+1];
		for(int i=0;i<=n;i++){
			table[i]=0;
		}
        int i=0;
		// Base case (If given value is 0)
		table[0] = 0;
		table[1]=0;
		table[2]=0;
		table[3]=1;

		// One by one consider given 3 moves and update the table[]
		// values after the index greater than or equal to the
		// value of the picked move
		for (i=4; i<=n; i++){
		    if(i>=3){
		        table[i]+=table[i-3];
		    }
		    if(i>=5){
		        table[i]+=table[i-5];
		    }
		    if(i>=10){
		        table[i]+=table[i-10];
		    }
		}

		return table[n];
	}




}
