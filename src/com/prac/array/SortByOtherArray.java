package com.prac.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SortByOtherArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
	    int A2[] = {2, 1, 8, 3};
	    sortByOtherArray(A1,A2);
	    for(int i=0;i<A1.length;i++){
	    	System.out.println(A1[i]);
	    }
	}

	public static void sortByOtherArray(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		int temp[]=new int[arr1.length];
		int idx=0;
		Map<Integer,Integer> map=new HashMap();
		Set setone=new HashSet();
		for(int i=0;i<arr1.length;i++){
			if(map.get(arr1[i])==null)
				map.put(arr1[i],1);
			else{
				int count=map.get(arr1[i]);
				map.put(arr1[i],count+1);
			}
		}
		for(int i=0;i<arr2.length;i++){
			int count=map.get(arr2[i]);
		    while(count>=1){
		    	temp[idx]=arr2[i];
		    	idx++;
		    	count--;
		    }
		    map.put(arr2[i],0);
		}
		Set<Integer> set=map.keySet();
		for(Integer temp1:set){
			if(map.get(temp1)!=0){
				temp[idx]=temp1;
				idx++;
			}
		}
		for(int i=0;i<idx;i++){
			arr1[i]=temp[i];
		}
	}

}
