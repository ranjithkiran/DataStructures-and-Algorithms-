package com.prac.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class NewComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer arg0, Integer arg1) {
		// TODO Auto-generated method stub
		return arg1.compareTo(arg0);
	}
	
}

public class KlargestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr[]={1, 23, 12, 9, 30, 2, 50};
        int k=3;
        KlargestElements(arr,k);
	}

	public static void KlargestElements(int[] arr, int k) {
		// TODO Auto-generated method stub
		Queue<Integer> queue=new PriorityQueue<>(k,new NewComparator());
		for(int i=0;i<arr.length;i++){
			queue.add(arr[i]);
		}
		
		for(int i=0;i<k;i++){
			int temp=queue.poll();
			System.out.println(temp);
		}
		
	}

}
