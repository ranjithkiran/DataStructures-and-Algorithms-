package com.prac.array;

public class SortedPviotedSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		int key = 1;
		System.out.println("Index: %d\n"+pivotedBinarySearch(arr1,0,arr1.length-1,key));
	}

	public static int pivotedBinarySearch(int[] arr, int low, int high, int element) {
		// TODO Auto-generated method stub
		if(low<=high){
			int mid=(low+high)/2;
			if(arr[mid]==element)
				return mid;
			if(arr[low]<arr[mid]){
				if(element>=arr[low] && element<arr[mid]){
					return pivotedBinarySearch(arr,low,mid-1,element);
				}else{
					return pivotedBinarySearch(arr,mid+1,high,element);
				}
					
			}
			if(arr[mid]<arr[high]){
				if(element>arr[mid] && element<=arr[high]){
					return pivotedBinarySearch(arr,mid+1,high,element);
				}else{
					return pivotedBinarySearch(arr,low,mid-1,element);	
				}
			}
		}
		return -1;
	}

}
