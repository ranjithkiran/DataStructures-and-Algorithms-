package com.prac.dp;

public class StairCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int s = 4, m = 2;
		 System.out.println("Nuber of ways = %d"+countWays(s, m));
	}

	private static int countWays(int s, int m) {
		// TODO Auto-generated method stub
		int res[]=new int[s+1];
		res[0]=0;
		res[1]=1;
		res[2]=2;
		for(int i=3;i<=s;i++){
			res[i]=res[i-1]+res[i-2];
		}
		return res[s];
	}

}
