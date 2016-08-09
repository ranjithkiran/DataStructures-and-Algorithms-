package com.prac.array;

import com.prac.search.BinarySearch;
public class ElemPosArrayInfinite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
		 int ans = findPos(arr, 160);
		 System.out.println("idx pos is"+ans);
	}

	private static int findPos(int[] arr, int element) {
		// TODO Auto-generated method stub
		int low=0;
		int high=1;
		int value=arr[high];
		while(element>value){
			low=high;
			high=2*low;
			value=arr[low];
		}
		return BinarySearch.binarySearchRecursive(arr, low, high, element);
	}

}
