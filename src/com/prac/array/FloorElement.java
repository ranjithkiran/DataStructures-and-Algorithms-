package com.prac.array;

public class FloorElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {1, 2, 8, 10, 10, 12, 19};
		 int x = 17;
		 int index = ceilSearch(arr, 0,arr.length-1, x);
		 System.out.println("index is"+index);
		 int flooridx=floorSearch(arr, 0,arr.length-1, x);
		 System.out.println("floor idx"+flooridx);
	}

	public static int ceilSearch(int[] arr, int low, int high, int x) {
		// TODO Auto-generated method stub
		if(low==high){
			if(x<=arr[low])
				return arr[low];
			else
				return -1;
		}
		if(low<high){
			int mid=(low+high)/2;
			if(arr[mid]==x)
				return arr[mid];
			if((mid+1<=high) && (x>arr[mid] && x<arr[mid+1])){
				return arr[mid+1];
			}
			if(mid-1>=low && x>arr[mid-1] && x<arr[mid]){
				return arr[mid];
			}
			if(x>arr[mid])
				return ceilSearch(arr,mid+1,high,x);
			else
				return ceilSearch(arr,low,mid-1,x);
		}
		return -1;
	}
	
	public static int floorSearch(int[] arr, int low, int high, int x) {
		// TODO Auto-generated method stub
		if(low==high){
			if(x>=arr[low])
				return arr[low];
			else
				return -1;
		}
		if(low<high){
			int mid=(low+high)/2;
			if(arr[mid]==x)
				return arr[mid];
			if((mid+1<=high) && (x>arr[mid] && x<arr[mid+1])){
				return arr[mid];
			}
			if(mid-1>=low && x>arr[mid-1] && x<arr[mid]){
				return arr[mid-1];
			}
			if(x>arr[mid])
				return floorSearch(arr,mid+1,high,x);
			else
				return floorSearch(arr,low,mid-1,x);
		}
		return -1;
	}

}
