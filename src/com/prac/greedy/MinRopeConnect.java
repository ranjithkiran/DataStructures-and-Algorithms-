package com.prac.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinRopeConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len[] = {4, 3, 2, 6};
	    System.out.println("Total cost for connecting ropes is "+ minCost(len, len.length-1));
	}

	private static int minCost(int[] len, int length) {
		// TODO Auto-generated method stub
		Queue<Integer> queue=new PriorityQueue<>();
		for(int i=0;i<=length;i++){
			queue.add(len[i]);
		}
		int res=0;
		while(queue.size()>1){
			int one=queue.poll();
			int two=queue.poll();
			res+=one+two;
			queue.add(one+two);
		}
		return res;
	}

}
