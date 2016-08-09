package com.prac.array;

import java.util.Scanner;

public class KClosestValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner x=new Scanner(System.in);
        System.out.println("enter size of the array");
        int size=x.nextInt();
        int array[]=new int[size];
        for(int i=0;i<array.length;i++){
        	array[i]=x.nextInt();
        }
        KclosestValues(array,4,35);
        System.out.println("after sorting");
        for(int i=0;i<array.length;i++){
        	System.out.print(array[i]+" ");
        }
        System.out.println();
	}
    
	public static int BinarySearch(int array[],int value){
		int low=0;
		int high=array.length-1;
		while(low<=high){
			int mid=(low+high)/2;
			if(array[mid]==value){
				return mid;
			}
			if(value>array[mid]){
				low=mid+1;
			}
			if(value<array[mid]){
				high=mid-1;
			}
		}
		return -1;
	}
	private static void KclosestValues(int[] array, int k, int value) {
		// TODO Auto-generated method stub
		if(BinarySearch(array, value)==-1){
			System.out.println("element not found");
			return;
		}
		int index=BinarySearch(array, value);
		int left=index-1;
		int right=index+1;
		while(left>=0 && right<=array.length-1 && k>=0){
			if(array[index]-array[left]>array[right]-array[index]){
				System.out.println(array[right]);
				right++;
			}
			if(array[index]-array[left]<array[right]-array[index]){
				System.out.println(array[left]);
				left--;
			}
			k--;
		}
		
        if(left<0){
        	while(k>=0){
        		System.out.println(array[right]);
        		right++;
        	}
        }
        if(right>array.length-1){
        	while(k>=0){
        		System.out.println(array[left]);
        		left--;
        	}
        }
	}

}
