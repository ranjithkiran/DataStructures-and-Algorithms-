package com.prac.array;

import java.util.*;
import java.lang.*;
import java.io.*;


public class SingleOddElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int arr[] = {1, 3, 3, 5, 5, 7, 7, 8, 8};
	    System.out.println("element is"+search(arr, 0,arr.length-1));
	}
	
	public static int search(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if(low==high){
			return arr[low];
		}
		if(low<high){
			int mid=(low+high)/2;
			if(arr[mid]==arr[mid+1]){
				if((high-(mid+1))%2==0){
					return search(arr,low,mid-1);
				}else{
					return search(arr,mid+2,high);
				}
			}else{
				if((high-(mid+1))%2==0){
					return search(arr,mid+1,high);
				}else{
					return search(arr,low,mid);
				}
			}
		}
			return -1;
 
		}
    }
