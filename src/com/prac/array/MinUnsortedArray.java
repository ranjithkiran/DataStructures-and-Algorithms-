package com.prac.array;

public class MinUnsortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		  printUnsorted(arr, arr.length);
	}

	private static void printUnsorted(int[] arr, int length) {
		// TODO Auto-generated method stub
		int start_idx=0;
		int end_idx=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>arr[i+1]){
				start_idx=i;
				break;
			}
		}
		
		for(int i=arr.length-1;i>=0;i--){
			if(arr[i]<arr[i-1]){
				end_idx=i;
				break;
			}
		}
		int min=arr[start_idx];
		int max=arr[end_idx];
		for(int i=start_idx+1;i<=end_idx;i++){
			if(arr[i]<min){
				min=arr[i];
			}
		}
		
		for(int i=end_idx-1;i>=start_idx;i--){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		for( int i = 0; i < start_idx; i++)
		  {
		    if(arr[i] > min)
		    {  
		    	start_idx = i;
		      break;
		    }      
		  } 
		  
		  // step 2(c) of above algo
		  for(int  i = arr.length -1; i >= end_idx+1; i--)
		  {
		    if(arr[i] < max)
		    {
		    	end_idx = i;
		      break;
		    } 
		  }  
		System.out.println("print value for start"+start_idx+ "and end index"+ end_idx);
	}

}
