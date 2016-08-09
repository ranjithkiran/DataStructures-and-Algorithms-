package com.prac.algo;

import java.util.Scanner;

public class BubbleSort {
	
	public static void swap(int [] array,int i,int j){
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	public static void bubblesort(int array[]){
		
		for(int i=0;i<array.length-1;i++){
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]>array[j+1]){
					swap(array,j,j+1);
				}
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
        bubblesort(array);
        System.out.println("after sorting");
        for(int i=0;i<array.length;i++){
        	System.out.print(array[i]+" ");
        }
        System.out.println();
	}

}
