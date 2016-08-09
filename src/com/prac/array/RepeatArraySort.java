package com.prac.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RepeatArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {100, 12, 100, 1, 1, 12, 100, 1, 12, 100, 1, 1};
		sort(arr,arr.length-1);
	}

	public static void sort(int[] arr, int length) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> map=new TreeMap<>();
		for(int i=0;i<arr.length;i++){
			if(map.get(arr[i])==null){
				map.put(arr[i], 1);
			}else{
				int count=map.get(arr[i]);
				map.put(arr[i], count+1);
			}
		}
		Set<Integer> set=map.keySet();
		int idx=0;
		for(Integer tempone:set){
			int temp=map.get(tempone);
			while(temp>=1){
				arr[idx]=tempone;
				idx++;
				temp--;
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

}
