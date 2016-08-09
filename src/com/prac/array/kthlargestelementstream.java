package com.prac.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class queueComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if(o2>o1) return 1;
		else if(o2==o1) return 0;
		else return -1;
	}

}

public class kthlargestelementstream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 3;
	    System.out.println("k is"+k);
	    kthLargest(k);
	}

	private static void kthLargest(int k) {
		// TODO Auto-generated method stub
		Queue<Integer> queue=new PriorityQueue<>(k,new queueComparator());
		Scanner x=new Scanner(System.in);
		int count=0;
		while(true){
			System.out.println("enter number to check and -1 to break");
			int temp=x.nextInt();
			count++;
			if(temp==-1)
				break;
			if(count<=k){
				queue.add(temp);
				
			}
			
			if(count>k){
				int root=queue.peek();
				if(temp>root){
					System.out.println("pollng element"+queue.poll());
					count--;
					queue.add(temp);
				    int tempone=queue.peek();
					System.out.println("max"+k+"thelement till now is"+tempone);
				}
			}
			if(count==k){
				int tempone=queue.peek();
				System.out.println("max"+k+"thelement till now iseeee"+tempone);
			}
		}
		
	}

}
