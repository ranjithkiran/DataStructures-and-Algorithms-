package com.prac.algo;

import java.util.Scanner;

public class ItrQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner x=new Scanner(System.in);
        System.out.println("enter size of the array");
        int size=x.nextInt();
        int array[]=new int[size];
        for(int i=0;i<array.length;i++){
        	array[i]=x.nextInt();
        }
        quicksortItr(array,0,array.length-1);
        System.out.println("after sorting");
        for(int i=0;i<array.length;i++){
        	System.out.print(array[i]+" ");
        }
        System.out.println();
	}
	
	public static int partition(int array[],int low,int high){
		int pivot=array[high];
		int idx=low-1;
		for(int j=0;j<=high-1;j++){
			if(array[j]<pivot){
				idx++;
				swap(array,idx,j);
			}
		}
		swap(array,idx+1,high);
		return idx+1;
	}

	private static void swap(int[] array, int idx, int j) {
		// TODO Auto-generated method stub
		int temp=array[idx];
		array[idx]=array[j];
		array[j]=temp;
		
	}

	private static void quicksortItr(int[] array,int low,int high) {
		// TODO Auto-generated method stub
		int stack[]=new int[high-low+1];
		int top=-1;
		stack[++top]=low;
		stack[++top]=high;
		while(top>=0){
			int highidx=stack[top--];
			int lowidx=stack[top--];
			int part=partition(array,lowidx,highidx);
			if(part-1>lowidx){
				stack[++top]=lowidx;
				stack[++top]=part-1;
			}
			if(part+1<highidx){
				stack[++top]=part+1;
				stack[++top]=highidx;
			}
			
		}
		
	}

}
