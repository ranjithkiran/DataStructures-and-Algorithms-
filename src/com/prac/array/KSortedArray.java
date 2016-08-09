package com.prac.array;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class KSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner x=new Scanner(System.in);
        System.out.println("enter size of the array");
        int size=x.nextInt();
        int array[]=new int[size];
        for(int i=0;i<array.length;i++){
        	array[i]=x.nextInt();
        }
        KSortArray(array,2);
        System.out.println("after sorting");
        for(int i=0;i<array.length;i++){
        	System.out.print(array[i]+" ");
        }
        System.out.println();
	}

	private static void KSortArray(int[] array,int k) {
		// TODO Auto-generated method stub
		int output[]=new int[array.length];
		int idx=0;
		Queue<Integer> queue=new PriorityQueue<>(k+1);
		for(int i=0;i<=k;i++){
			queue.add(array[i]);
		}
		
		for(int i=k+1;i<array.length;i++){
			output[idx]=queue.poll();
			idx++;
			queue.add(array[i]);
		}
		while(!queue.isEmpty()){
			output[idx]=queue.poll();
			idx++;
		}
		for(int i=0;i<array.length;i++){
			array[i]=output[i];
		}
		
	}

}
