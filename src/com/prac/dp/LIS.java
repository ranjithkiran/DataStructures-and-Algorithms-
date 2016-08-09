package com.prac.dp;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is " + lis( arr, n ) + "\n" );
	}

	public static int  lis(int[] arr, int length) {
		// TODO Auto-generated method stub
		int lis1[]=new int[length];
		for(int i=0;i<length;i++){
			lis1[i]=1;
		}
		for(int i=1;i<length;i++){
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j] && lis1[j]+1>lis1[i])
					lis1[i]=lis1[j]+1;
			}
		}
		int max=lis1[0];
		for(int i=1;i<length;i++){
			if(lis1[i]>max)
				max=lis1[i];
		}
		return max;
	}

}
