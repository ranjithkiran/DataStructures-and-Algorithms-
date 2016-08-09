package com.prac.array;

public class LargestPairSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]={12, 34, 10, 6, 40};
		System.out.println("largest pair value is"+largestPairSum(arr));
	}

	public static int largestPairSum(int[] arr) {
		// TODO Auto-generated method stub
		int first_max,second_max=0;
		if(arr[0]>arr[1]){
			first_max=arr[0];
			second_max=arr[1];
		}else{
			first_max=arr[1];
			second_max=arr[0];
		}
		for(int i=2;i<=arr.length-1;i++){
			if(arr[i]>first_max){
				second_max=first_max;
				first_max=arr[i];
			}
			else if(arr[i]>second_max){
				second_max=arr[i];
			}
		}
		return first_max+second_max;
	}

}
