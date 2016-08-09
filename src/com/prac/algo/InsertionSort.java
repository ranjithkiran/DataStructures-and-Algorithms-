package com.prac.algo;

import java.util.Scanner;

public class InsertionSort {
	
	public static void swap(int [] array,int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	public static void insertionsort(int array[]){
		
		for(int j=1;j<array.length;j++){
			int key=array[j];
			int i=j-1;
			while(i>=0 && array[i]>key){
				array[i+1]=array[i];
			    i--;
			}
			array[i+1]=key;
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
        insertionsort(array);
        System.out.println("after sorting");
        for(int i=0;i<array.length;i++){
        	System.out.print(array[i]+" ");
        }
        System.out.println();
	}

}
