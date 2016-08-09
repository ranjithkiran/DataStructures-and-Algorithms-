package com.prac.array;

public class KthSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] =  {10, 3, 40, 20, 50, 80, 70};
		int k=2;
		System.out.println(kthSmallest(arr,0,arr.length-1,k));
	}


	private static int kthSmallest(int[] arr, int i, int j, int k) {
		// TODO Auto-generated method stub
		if(k>=0 && k<=j-i+1){
			int position=partition(arr,i,j);
			if(position-i==k-1){
				return arr[position];
			}
			
			if(position-i>k-1){
				return kthSmallest(arr,i,position-1,k);
			}
			else if(position-i<k-1){
				return kthSmallest(arr,position+1,j,k-position+i-1);
			}
		}
		return -1;
		
	}
	
	private static int partition(int arr[],int low,int high){
		int pivot=arr[high];
		int idx=low-1;
		for(int j=low;j<=high-1;j++){
			if(arr[j]<pivot){
				idx++;
				swap(arr,idx,j);
			}
		}
		swap(arr,idx+1,high);
		return idx+1;
	}


	private static void swap(int[] arr, int idx, int j) {
		// TODO Auto-generated method stub
		int temp=arr[idx];
		arr[idx]=arr[j];
		arr[j]=temp;
	}

}
