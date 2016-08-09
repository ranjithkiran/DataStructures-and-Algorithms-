package com.prac.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BucketSort {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner x=new Scanner(System.in);
        System.out.println("enter size of the array");
        int size=x.nextInt();
        int array[]=new int[size];
        for(int i=0;i<array.length;i++){
        	array[i]=x.nextInt();
        }
        bucketsort(array);
        System.out.println("after sorting");
        for(int i=0;i<array.length;i++){
        	System.out.print(array[i]+" ");
        }
        System.out.println();
	}

	private static void bucketsort(int[] array) {
		// TODO Auto-generated method stub
		List list[]=new ArrayList[10];
		for(int i=0;i<10;i++){
			list[i]=new ArrayList();
		}
		for(int i=0;i<array.length;i++){
			int temp=array[i]/10;
			list[temp].add(array[i]);
		}
		for(int i=0;i<10;i++){
			Collections.sort(list[i]);
		}
		int index=0;
		for(int i=0;i<10;i++){
			Iterator itr=list[i].iterator();
			while(itr.hasNext()){
				array[index]=(int) itr.next();
				index++;
			}
			
		}
	}

}
