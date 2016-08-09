package com.prac.array;

public class WaveArray {
	
	public static void swap(int array[],int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 90, 49, 2, 1, 5, 23};
	    sortInWave(arr, arr.length-1);
	    System.out.println("after sorting");
	    for (int i=0; i<=arr.length-1; i++){
	    	System.out.println(arr[i]);
	    }
	     
	}

	private static void sortInWave(int[] arr, int length) {
		// TODO Auto-generated method stub
		for(int i=1;i<=length-1;i++){
			if(i%2!=0){
				if(arr[i]>arr[i-1]){
					swap(arr,i,i-1);
				}
			}else{
				if(arr[i]<arr[i-1]){
					swap(arr,i,i-1);
				}
			}
			
		}
	}

}
