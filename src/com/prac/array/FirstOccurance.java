package com.prac.array;

public class FirstOccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] =  {1, 1, 2, 2, 2, 2, 3};
		int x =  1;  // Element to be counted in arr[]endOccurance
		int first=endOccurance(arr,0,arr.length-1,x);
		int second=firstOccurance(arr,0,arr.length-1,x);
		System.out.println("no of elements"+(first-second+1));
		
	}

	public static int firstOccurance(int[] arr, int low, int high, int element) {
		// TODO Auto-generated method stub
		if(low==high){
			if(arr[low]==element){
				return low;
			}
			return -1;
		}
		if(low<high){
			int mid=(low+high)/2;
			if(mid-1>=low && arr[mid]==element && arr[mid-1]!=arr[mid]){
				return mid;
			}
			if(element>arr[mid]){
				return firstOccurance(arr,mid+1,high,element);
			}else{
				return firstOccurance(arr,low,mid-1,element);
			}
		}
		return -1;
	}
	
	public static int endOccurance(int[] arr, int low, int high, int element) {
		// TODO Auto-generated method stub
		if(low==high){
			if(arr[low]==element){
				return low;
			}
			return -1;
		}
		if(low<high){
			int mid=(low+high)/2;
			if(mid+1<=high && arr[mid]==element && arr[mid]!=arr[mid+1]){
				return mid;
			}
			if(element>=arr[mid]){
				return endOccurance(arr,mid+1,high,element);
			}else{
				return endOccurance(arr,low,mid-1,element);
			}
		}
		return -1;
	}

}
