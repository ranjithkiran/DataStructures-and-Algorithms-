package com.prac.algo;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Scanner x=new Scanner(System.in);
		        System.out.println("enter size of the array");
		        int size=x.nextInt();
		        int array[]=new int[size];
		        for(int i=0;i<array.length;i++){
		        	array[i]=x.nextInt();
		        }
		        countSort(array);
		        System.out.println("after sorting");
		        for(int i=0;i<array.length;i++){
		        	System.out.print(array[i]+" ");
		        }
		        System.out.println();

	}

	private static void countSort(int[] array) {
		// TODO Auto-generated method stub
		int max=array[0];
		int output[] =new int[array.length];
		for(int i=1;i<array.length;i++){
			if(array[i]>max){
				max=array[i];
			}
		}
		int count[]=new int[max+1];
		Arrays.fill(count, 0);
		for(int i=0;i<array.length;i++){
			count[array[i]]++;
		}
		for(int i=1;i<count.length;i++){
			count[i]=count[i-1]+count[i];
		}
		for(int i=0;i<array.length;i++){
			output[count[array[i]]-1]=array[i];
			count[array[i]]--;
		}
		for(int i=0;i<array.length;i++){
			array[i]=output[i];
		}
	}

}
