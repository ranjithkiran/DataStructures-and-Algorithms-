package com.prac.algo;

import java.util.Scanner;

public class MergeSort {
    
	public static void mergesort(int array[],int low,int high){
		if(low<high){
			int mid=(low+high)/2;
			mergesort(array,low,mid);
			mergesort(array,mid+1,high);
			merge(array,low,mid,high);
		}
		
	}
	public static void merge(int[] array, int low, int mid, int high) {
		// TODO Auto-generated method stub
		int leftmin=low;
		int leftmax=mid;
		int rightmin=mid+1;
		int rightmax=high;
		int size=0;
	    int temp[]=new int[high-low+1];
	    while(leftmin<=leftmax && rightmin<=rightmax){
	    	if(array[leftmin]<array[rightmin]){
	    		temp[size]=array[leftmin];
	    		leftmin++;
	    		size++;
	    	}
	    	else if(array[leftmin]>array[rightmin]){
	    		temp[size]=array[rightmin];
	    		rightmin++;
	    		size++;
	    	}
	    	else if(array[leftmin]==array[rightmin]){
	    		temp[size]=array[rightmin];
	    		rightmin++;
	    		leftmin++;
	    		size++;
	    	}
	    	
	    }
	    if(leftmin>leftmax){
	    	while(rightmin<=rightmax){
	    		temp[size]=array[rightmin];
	    		rightmin++;
	    		size++;
	    	}
	    }
	    
	    if(rightmin>rightmax){
	    	while(leftmin<=leftmax){
	    		temp[size]=array[leftmin];
	    		leftmin++;
	    		size++;
	    	}
	    }
	    for(int i=0;i<size;i++){
	    	array[low+i]=temp[i];
	    }
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner x=new Scanner(System.in);
        System.out.println("enter size of the array");
        int size=x.nextInt();
        int array[]=new int[size];
        for(int i=0;i<array.length;i++){
        	array[i]=x.nextInt();
        }
        mergesort(array,0,array.length-1);
        System.out.println("after sorting");
        for(int i=0;i<array.length;i++){
        	System.out.print(array[i]+" ");
        }
        System.out.println();
	}

}
