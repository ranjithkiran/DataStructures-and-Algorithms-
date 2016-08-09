package com.prac.greedy;

public class MinCashFlow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = { {0, 1000, 2000},
                {0, 0, 5000},
                {0, 0, 0},};
        // Print the solution
        minCashFlow(graph);
	}

	public static void minCashFlow(int[][] graph) {
		// TODO Auto-generated method stub
		int len=graph.length;
		int amount[]=new int[len];
		for(int i=0;i<len;i++){
			amount[i]=0;
		}
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				amount[i]+=graph[j][i]-graph[i][j];
			}
		}
		minCashFlowRec(amount);
	}

	public static void minCashFlowRec(int[] amount) {
		// TODO Auto-generated method stub
		int max_debit_idx,max_credit_idx=0;
		max_debit_idx=minAmount(amount);
		max_credit_idx=maxAmount(amount);
		if(amount[max_credit_idx]==0 && amount[max_debit_idx]==0)
			return;
		int min=minof2(-amount[max_debit_idx],amount[max_credit_idx]);
		amount[max_credit_idx]+=-(min);
		amount[max_debit_idx]+=min;
		System.out.println("payee"+max_debit_idx+" pays "+min+" to"+max_credit_idx);
		minCashFlowRec(amount);
	}
	
	public static int minof2(int i, int j) {
		// TODO Auto-generated method stub
		if(i<j)
			return i;
		else
			return j;
	}

	public static int minAmount(int [] amount){
		int min_idx=0;
		for(int i=0;i<amount.length;i++){
			if(amount[i]<amount[min_idx]){
				min_idx=i;
			}
		}
		return min_idx;
	}
	
	public static int maxAmount(int [] amount){
		int max_idx=0;
		for(int i=0;i<amount.length;i++){
			if(amount[i]>amount[max_idx]){
				max_idx=i;
			}
		}
		return max_idx;
	}

}
