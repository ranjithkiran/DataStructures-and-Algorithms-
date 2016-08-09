package com.prac.greedy;

import java.util.Arrays;

public class ActivitySelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s[] =  {1, 3, 0, 5, 8, 5};
	    int f[] =  {2, 4, 6, 7, 9, 9};
	    printMaxActivities(s, f, s.length-1);
	}

	public static void printMaxActivities(int[] start, int[] finish, int length) {
		// TODO Auto-generated method stub
		Arrays.sort(finish);
		int count=1;
		int j=0;
		System.out.println("task no"+j);
		for(int i=1;i<length;i++){
			if(start[i]>=finish[j]){
				j=i;
				count++;
				System.out.println("task no"+i);
			}
		}
	}

}
