package com.prac.array;

import java.util.Arrays;

public class MinDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 5, 3, 19, 18, 25};
		   
		 System.out.println("Minimum difference is"+findMinDiff(arr, arr.length-1));
	}

	public static int findMinDiff(int[] arr, int length) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		int min_diff=arr[1]-arr[0];
		for(int i=1;i<=arr.length-2;i++){
			if(arr[i+1]-arr[i]<min_diff){
				min_diff=arr[i+1]-arr[i];
			}
		}
		
		return min_diff;
	}

}
