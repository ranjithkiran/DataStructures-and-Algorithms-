package com.prac.greedy;

class Item implements Comparable<Item>{
	int value;
	int weight;
	public Item(int value,int weight){
		this.value=value;
		this.weight=weight;
	}
	@Override
	public int compareTo(Item arg0) {
		// TODO Auto-generated method stub
		double value1=this.value/this.weight;
		double value2=arg0.value/arg0.weight;
		return (int) (value1-value2);
	}
}
public class FractionalKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int W = 50;   //    Weight of knapsack
	    Item arr[] = new Item[3];
	    arr[0]=new Item(60,10);
	    arr[1]=new Item(100,20);
	    arr[2]=new Item(120,30);
	    System.out.println("Maximum value we can obtain = "+getfractionalKnapsack(W, arr, arr.length));
	}

	public static int getfractionalKnapsack(int w, Item[] arr, int length) {
		// TODO Auto-generated method stub
		int current_weight=0;
		int value=0;
		for(int i=0;i<length;i++){
			if(current_weight+arr[i].weight<=w){
				current_weight+=arr[i].weight;
				value+=arr[i].value;
			}else{
				int rem_weight=Math.abs(w-current_weight);
				value+=rem_weight*(arr[i].value/arr[i].weight);
				break;
			}
		}
		return value;
	}

}
