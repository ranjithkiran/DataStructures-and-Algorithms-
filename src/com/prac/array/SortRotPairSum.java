package com.prac.array;

import com.prac.array.RotateSortArr;
public class SortRotPairSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] ={11, 15, 6, 8, 9, 10};
	    int sum = 16;
	    System.out.println(" pair exsistes or not"+pairInSortedRotated(arr,arr.length,sum));
	}

	private static boolean pairInSortedRotated(int[] arr, int length,int sum) {
		// TODO Auto-generated method stub
		int idx=RotateSortArr.rotateArrIdx(arr, 0, length-1);
		int end=idx;
		int low=(idx+1)%length;
		while(low!=end){
			if(arr[low]+arr[end]==sum){
				return true;
			}
			else if(arr[low]+arr[end]<sum){
				low=(low+1)%length;
			}
			else{
				end=(end-1+length)%length;
			}
		}
		return false;
	}

}
