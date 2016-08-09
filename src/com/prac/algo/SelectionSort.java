package com.prac.algo;

import java.util.Scanner;

public class SelectionSort {
	
	public static void swap(int [] array,int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	public static void selectionsort(int array[]){
		for(int i=0;i<array.length-1;i++){
			int min_idx=i;
			for(int j=i+1;j<array.length;j++){
				if(array[j]<array[min_idx]){
					min_idx=j;
				}
			}
			if(min_idx!=i){
				swap(array,min_idx,i);
			}
			
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
        selectionsort(array);
        System.out.println("after sorting");
        for(int i=0;i<array.length;i++){
        	System.out.print(array[i]+" ");
        }
        System.out.println();
	}

}
