package com.prac.array;

import java.util.Arrays;

public class CloseZeroPairArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 60, -10, 70, -80, 85};
		  minAbsSumPair(arr, 6);
	}

	public static void minAbsSumPair(int[] arr, int i) {
		// TODO Auto-generated method stub
		int min_sum=Integer.MAX_VALUE;
		int sum=0;
		int start=0;
		int end=arr.length-1;
		int min_start=0;
		int min_end=0;
		Arrays.sort(arr);
		if(arr.length<2){
			System.out.println("invalid input");
			return;
		}
		while(start<end){
			int sumone=arr[start]+arr[end];
			if(Math.abs(sumone)<Math.abs(min_sum)){
				min_sum=Math.abs(sum);
				min_start=start;
				min_end=end;
			}
			if(sumone<0)
				start++;
			else{
				end--;
			}
		}
		System.out.println("start and end of the array and value in the array are "+arr[min_start]+"  "+arr[min_end]);
		    
	}

}
