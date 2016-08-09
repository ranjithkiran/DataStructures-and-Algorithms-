package com.prac.array;

import java.util.Scanner;

public class AlmostSortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Scanner x=new Scanner(System.in);
        System.out.println("enter size of the array");
        int size=x.nextInt();
        int array[]=new int[size];
        for(int i=0;i<array.length;i++){
        	array[i]=x.nextInt();
        }*/
		int arr[] =  {10, 3, 40, 20, 50, 80, 70};
		int element=3;
        if(srchAlmostSort(arr,0,arr.length-1,element)==-1){
        	System.out.println("element is not presenet in array");
        }else{
        	int idx=srchAlmostSort(arr,0,arr.length-1,element);
        	System.out.println("element is present at"+(idx+1));
        }
       /* System.out.println("after sorting");
        for(int i=0;i<array.length;i++){
        	System.out.print(array[i]+" ");
        }
        System.out.println();*/
	}

	private static int srchAlmostSort(int[] array,int low,int high, int element) {
		// TODO Auto-generated method stub
		if(low<=high){
			int mid=(low+high)/2;
			if(array[mid]==element)
				return mid;
			if(mid+1<=high && array[mid+1]==element)
				return mid+1;
			if((mid-1)>=low && array[mid-1]==element)
				return mid-1;
			if(element>array[mid])
				return srchAlmostSort(array,mid+1,high,element);
			else
				return srchAlmostSort(array,low,mid-1,element);
			
		}
		return -1;
	}

}
