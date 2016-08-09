package com.prac.dp;

public class DiceThrow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findWaysDp(4, 2, 1));
		System.out.println(findWaysDp(2, 2, 3));
		System.out.println(findWaysDp(6, 3, 8));
		System.out.println(findWaysDp(4, 2, 5));
	}

	public static int findWays(int face, int num, int sum) {
		// TODO Auto-generated method stub
		if(sum==0 && num==0)
			return 1;
		if(sum<=0 || num<=0)
			return 0;
		int ans=0;
		for(int i=1;i<=face;i++){
			ans+=findWays(face,num-1,sum-i);
		}
		return ans;
	}
	
	public static int findWaysDp(int face, int num, int sum) {
		int table[][]=new int[num+1][sum+1];
		for(int i=0;i<=num;i++){
			for(int j=0;j<=sum;j++){
				table[i][j]=0;
			}
		}
		for(int j=1;j<=sum && j<=face;j++){
			table[1][j]=1;
		}
		for(int i=2;i<=num;i++){
			for(int j=1;j<=sum;j++){
				for(int x=1;x<=face && x<j;x++){
					table[i][j]+=table[i-1][j-x];
				}
			}
		}
		return table[num][sum];
	}

}
