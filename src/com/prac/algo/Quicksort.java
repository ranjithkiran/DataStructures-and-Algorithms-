package com.prac.algo;

import java.util.Scanner;

public class Quicksort {
	
	public static void swap(int [] array,int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	public static void quicksort(int array[],int low,int high){
		if(low<high){
			int partition=partition(array,low,high);
			quicksort(array,low,partition-1);
			quicksort(array,partition+1,high);
		}
		
	}
	
	public static int partition(int array[],int low,int high){
		int pivotidx=low-1;
		int pivot=array[high];
		for(int i=low;i<=high-1;i++){
			if(array[i]<pivot){
				pivotidx++;
				swap(array,i,pivotidx);
			}
		}
		swap(array,pivotidx+1,high);
		return pivotidx+1;
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
        quicksort(array,0,array.length-1);
        System.out.println("after sorting");
        for(int i=0;i<array.length;i++){
        	System.out.print(array[i]+" ");
        }
        System.out.println();
	}

}
