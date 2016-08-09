package com.prac.search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	
	public static int linearSearch(int array[],int element){
		
		for(int i=0;i<array.length;i++){
			if(array[i]==element){
				return i+1;
			}
		}
		
		return -1;
		
	}
	
	public static int binarySearch(int array[],int element){
		int low=0;
		int high=array.length-1;
		while(low<=high){
			int mid=(low+high)/2;
			if(array[mid]==element){
				return mid;
			}
			if(element>array[mid]){
				low=mid+1;
			}
			if(element<array[mid]){
				high=mid-1;
			}
			
		}
		return -1;
	}
	
	public static int binarySearchRecursive(int array[],int low,int high,int element){
	        if(low<=high){
		    	int mid=(low+high)/2;
		         if(array[mid]==element)
		        	 return mid;
		         if(element<array[mid])
		        	 return binarySearchRecursive(array,low,mid-1,element);
		         if(element>array[mid])
		        	 return binarySearchRecursive(array,mid+1,high,element);
		    }
	   return -1;	    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner x=new Scanner(System.in);
        System.out.println("enter no of elements of array");
        int size=x.nextInt();
        int array[]=new int[size];
        for(int i=0;i<size;i++){
        	array[i]=x.nextInt();
        }
        int element=23;
        Arrays.sort(array);
        //System.out.println("linear search element is present at"+binarySearch(array,element)+"index");
        System.out.println("rec binary search element"+element+"is present at"+binarySearchRecursive(array,0,array.length-1,element));
	}

}

