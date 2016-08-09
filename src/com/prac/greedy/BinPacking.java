package com.prac.greedy;

import java.util.Arrays;

public class BinPacking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int weight[] = {2, 5, 4, 7, 1, 3, 8};
	    int c = 10;
	   System.out.println("Number of bins required in Next Fit : "+nextFit(weight, weight.length, c));
	}

	public static int nextFit(int[] weight, int length, int c) {
		// TODO Auto-generated method stub
		int res=1;
		int bin_capacity=c;
		Arrays.sort(weight);
		for(int i=0;i<length;i++){
			if(weight[i]>bin_capacity){
			     res++;
			     bin_capacity=c-weight[i];
			}else{
				bin_capacity=bin_capacity-weight[i];
			}
		}
		return res;
	}

}
