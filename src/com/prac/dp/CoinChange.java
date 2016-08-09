package com.prac.dp;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3};
	    int n = 4;
	    System.out.println("value is"+countCoinDp(arr, arr.length, n));
	}

	public static int countCoinRec(int[] arr, int arrsize, int value) {
		// TODO Auto-generated method stub
		if(value==0)
			return 1;
		if(arrsize<0)
			return 0;
		int max_value=0;
		for(int i=0;i<arrsize;i++){
			value=value-arr[i];
			if(value<0)
				break;
			max_value+=countCoinRec(arr,arrsize,value);
		}
		return max_value;
	}
	
	public static int countCoinDp(int[] arr, int arrsize, int value) {
		int[][] coinDP=new int[arr.length+1][value+1];
		for(int i=1;i<=value;i++){
			coinDP[0][i]=0;
		}
		for(int i=0;i<=arr.length;i++){
			coinDP[i][0]=1;
		}
		
		for(int i=1;i<=arrsize;i++){
			for(int j=1;j<=value;j++){
				if(arr[i-1]<=j)
					coinDP[i][j]=coinDP[i-1][j]+coinDP[i][j-arr[i-1]];
				else
					coinDP[i][j]=coinDP[i][j-1];
			}
		}
		return coinDP[arr.length][value];
	}

}
