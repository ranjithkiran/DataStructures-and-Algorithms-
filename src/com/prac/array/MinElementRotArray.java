package com.prac.array;

public class MinElementRotArray {
	  public static void main(String[] args){
		  int arr1[] =  {5, 6, 1, 2, 3, 4};
		    
		    System.out.println("The minimum element is %d\n"+ findMin(arr1, 0, arr1.length-1));
		 
		    int arr2[] =  {1, 2, 3, 4};
		    //int n2 = sizeof(arr2)/sizeof(arr2[0]);
		    System.out.println("The minimum element is %d\n"+findMin(arr2, 0,arr2.length-1));
		 
		    int arr3[] =  {1};
		    //int n3 = sizeof(arr3)/sizeof(arr3[0]);
		    System.out.println("The minimum element is %d\n"+findMin(arr3, 0,arr3.length-1));
		 
		    int arr4[] =  {1, 2};
		    //int n4 = sizeof(arr4)/sizeof(arr4[0]);
		    System.out.println("The minimum element is %d\n"+findMin(arr4, 0,arr4.length-1));
		 
		    int arr5[] =  {2, 1};
		    //int n5 = sizeof(arr5)/sizeof(arr5[0]);
		    System.out.println("The minimum element is %d\n"+ findMin(arr5, 0,arr5.length-1));
		 
		    int arr6[] =  {5, 6, 7, 1, 2, 3, 4};
		    //int n6 = sizeof(arr6)/sizeof(arr6[0]);
		    System.out.println("The minimum element is %d\n"+ findMin(arr6, 0,arr6.length-1));
		 
		    int arr7[] =  {1, 2, 3, 4, 5, 6, 7};
		    //int n7 = sizeof(arr7)/sizeof(arr7[0]);
		    System.out.println("The minimum element is %d\n"+findMin(arr7, 0,arr7.length-1));
		 
		    int arr8[] =  {2, 3, 4, 5, 6, 7, 8, 1};
		    //int n8 = sizeof(arr8)/sizeof(arr8[0]);
		    System.out.println("The minimum element is %d\n"+findMin(arr8, 0,arr8.length-1));
		 
		    int arr9[] =  {3, 4, 5, 1, 2};
		    //int n9 = sizeof(arr9)/sizeof(arr9[0]);
		    System.out.println("The minimum element is %d\n"+ findMin(arr9, 0,arr9.length-1));
	  }
	   

	private static int findMin(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		  if(low<high){
			  int mid=(low+high)/2;
			  if((mid+1<=high) && arr[mid]>arr[mid+1]){
				  return arr[mid+1];
			  }
			  if((mid-1>=low) && (arr[mid-1]>arr[mid])){
				  return arr[mid];
			  }
			  if(arr[mid]<=arr[high]){
				  return findMin(arr,low,mid-1);
			  }else{
				  return findMin(arr,mid,high);
			  }
		  }
		    return arr[low];
		
	}
}