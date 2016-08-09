package com.prac.array;

public class RotateSortArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   int arr[] = {99,105, 16, 17, 18, 99};
	       int idx=rotateArrIdx(arr,0,arr.length-1);
	       System.out.println("idx is"+idx);
	}

	public static int rotateArrIdx(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if(low<high){
			int mid=(low+high)/2;
			if((mid+1<=high) && (arr[mid]>arr[mid+1])){
				return mid;
			}
			if(arr[low]<=arr[mid]){
				return rotateArrIdx(arr,mid+1,high);
			}else{
				return rotateArrIdx(arr,low,mid);
			}
		}
		return -1;
		
	}

}
