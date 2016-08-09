package com.prac.array;

public class elementonce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 1, 2, 4, 4, 5, 5, 6, 6};
	    search(arr, 0, arr.length-1);
	}

	public static int search(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if(low<high){
			int mid=(low+high)/2;
			if((mid+1<=high) && (arr[mid+1]!=arr[mid])){
				
			}
		}
		return high;
	
	}

}
