package com.prac.greedy;

import java.util.ArrayList;
import java.util.List;

public class MinNumberCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int deno[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
		int n=93;
		findMinCoins(deno,n);
	}

	public static void findMinCoins(int[] deno, int number) {
		// TODO Auto-generated method stub
		List<Integer> coinlist=new ArrayList();
		for(int i=deno.length-1;i>=0;i--){
			while(number>=deno[i]){
				number=number-deno[i];
			    coinlist.add(deno[i]);
			}
		}
		for(int i=0;i<coinlist.size();i++){
			System.out.println(coinlist.get(i));
		}
	}

}
