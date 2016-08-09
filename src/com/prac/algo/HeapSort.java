package com.prac.algo;

import java.util.Scanner;

public class HeapSort {
	
	public static void swap(int [] array,int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
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
        heapsort(array);
        System.out.println("after sorting");
        for(int i=0;i<array.length;i++){
        	System.out.print(array[i]+" ");
        }
        System.out.println();
	}




	private static void heapsort(int[] array) {
		// TODO Auto-generated method stub
		
		for(int i=(array.length-2)/2;i>=0;i--){
			heapify(array,i,array.length);
		}
		
		System.out.println("after heapying");
        for(int i=0;i<array.length;i++){
        	System.out.print(array[i]+" ");
        }
        
		for(int i=array.length-1;i>0;i--){
			swap(array,0,i);
			heapify(array,0,i);
		}
		
	}
	
	public static void heapify(int array[],int index,int size){
		int left=2*index+1;
		int right=2*index+2;
		int largest=index;
		if(left<size && array[largest]<array[left]){
			largest=left;
		}
		if(right<size && array[largest]<array[right]){
			largest=right;
		}
		
		if(largest!=index){
			swap(array,largest,index);
			heapify(array,largest,size);
		}
		
	}

}
