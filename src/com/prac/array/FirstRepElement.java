package com.prac.array;

import java.util.HashSet;
import java.util.Set;

public class FirstRepElement {

	 public static void main (String[] args) throws java.lang.Exception
	    {
	        int arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10};
	        System.out.println("min idx is"+printFirstRepeating(arr));
	    }

	private static int printFirstRepeating(int[] arr) {
		// TODO Auto-generated method stub
		Set<Integer> set=new HashSet<Integer>();
		int length=arr.length-1;
		int min_idx=Integer.MAX_VALUE;
		while(length>=0){
			if (set.contains(arr[length])==false){
				set.add(arr[length]);
			}
			else{
				if(length<min_idx){
					min_idx=length;
				}
			}
			length--;
		}
		return min_idx;
	}

}
