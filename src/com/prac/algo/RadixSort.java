package com.prac.algo;

import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner x=new Scanner(System.in);
        System.out.println("enter size of the array");
        int size=x.nextInt();
        int array[]=new int[size];
        for(int i=0;i<array.length;i++){
        	array[i]=x.nextInt();
        }
        radixsort(array);
        System.out.println("after sorting");
        for(int i=0;i<array.length;i++){
        	System.out.print(array[i]+" ");
        }
        System.out.println();
	}

	private static void radixsort(int[] array) {
		// TODO Auto-generated method stub
		int max=array[0];
		for(int i=0;i<array.length;i++){
			if(array[i]>max){
				max=array[i];
			}
		}
		
		for(int exp=1;max/exp>0;exp*=10){
			countSort(array,exp);
		}
	}
	
	private static void countSort(int array[],int exp){
		int output[]=new int[array.length];
		int count[]=new int[10];
		Arrays.fill(count, 0);
		for(int i=0;i<array.length;i++){
			int value=(array[i]/exp)%(10);
			count[value]++;
		}
		
		for(int i=1;i<10;i++){
			count[i]=count[i]+count[i-1];
		}
		for(int i=array.length-1;i>=0;i--){
			output[count[ (array[i]/exp)%10 ] - 1] = array[i];
            count[ (array[i]/exp)%10 ]--;
		}
		for(int i=0;i<array.length;i++){
			array[i]=output[i];
		}
		
	}

}
