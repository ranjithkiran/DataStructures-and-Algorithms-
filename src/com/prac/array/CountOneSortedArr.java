package com.prac.array;

public class CountOneSortedArr {

	 public static void main(String args[])
	    {
	       int arr[] = {0, 0, 0, 0, 0, 0, 0};
	       int n = arr.length;
	       int temp=countOnes(arr, 0, n-1);
	       System.out.println("Count of 1's in given array is " +
	    		   temp );
	    }

	private static int countOnes(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if(low<=high){
			int mid=(low+high)/2;
			if((mid == high) && (arr[mid] == 1))
                return mid+1;
			if(mid+1<=high && arr[mid]==1 && arr[mid+1]==0)
				return mid+1;
			if(arr[mid]==1){
				return countOnes(arr,mid+1,high);
			}else
				return countOnes(arr,low,mid-1);
		}
		return -1;
	}

}
