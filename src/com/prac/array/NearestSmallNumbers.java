package com.prac.array;

import java.util.Stack;

public class NearestSmallNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 3, 0, 2, 5};
	    printPrevSmaller(arr, arr.length-1);
	}

	public static void printPrevSmaller(int[] arr, int length) {
		// TODO Auto-generated method stub
		Stack<Integer> st=new Stack();
		for(int i=0;i<=length;i++){
			while(!st.isEmpty() && st.peek()>=arr[i]){
				st.pop();
			}
			if(st.isEmpty()){
				System.out.println("_");
			}else{
				System.out.println(st.peek());
			}
			st.push(arr[i]);
			
		}
	}

}
