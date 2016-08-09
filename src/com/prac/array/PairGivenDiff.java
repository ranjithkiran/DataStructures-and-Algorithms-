package com.prac.array;

import java.util.Arrays;

public class PairGivenDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 8, 30, 40, 100};
        int n = 60;
        findPair(arr,n);
	}

	public static void findPair(int[] arr, int n) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		int start=0;
		int end=arr.length-1;
		while(start<end){
			if(arr[end]-arr[start]==n)
				System.out.println("values are"+arr[end]+"and"+arr[start]);
			if(arr[end]-arr[start]>n){
				start++;
			}else{
				end--;
			}
		}
	}

}
