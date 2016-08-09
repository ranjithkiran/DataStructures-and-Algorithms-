package com.prac.array;

public class PeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 20};
		System.out.println("peak value is"+findPeak(arr,0,arr.length-1));
	}

	public static int findPeak(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if(low==high){
			return low;
		}
		if(low<high){
			int mid=(low+high)/2;
			
			if(mid+1<=high && mid-1>=low && arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
				return mid;
			}
			if(arr[mid]<arr[mid+1]){
				return findPeak(arr,mid,high);
			}
			else if(arr[mid]<arr[mid-1]){
				return findPeak(arr,low,mid);
			}
		}
		return -1;
	}

}
