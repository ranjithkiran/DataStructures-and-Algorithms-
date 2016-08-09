package com.prac.array;

public class PeaKForArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
	    System.out.println("peak element is"+findElement(arr));
	}

	public static int findElement(int[] arr) {
		// TODO Auto-generated method stub
		int leftMax[]=new int[arr.length];
		int rightMin[]=new int[arr.length];
		leftMax[0]=Integer.MIN_VALUE;
		for(int i=1;i<arr.length;i++){
			leftMax[i]=max(leftMax[i-1],arr[i-1]);
		}
		rightMin[arr.length-1]=Integer.MAX_VALUE;
		for(int i=arr.length-2;i>=0;i--){
			rightMin[i]=min(rightMin[i+1],arr[i+1]);
		}
		for(int i=1;i<=arr.length-2;i++){
			if(arr[i]>leftMax[i] && arr[i]<rightMin[i]){
				return i;
			}
		}
		return -1;
	}

	private static int min(int a, int b) {
		// TODO Auto-generated method stub
		if(a<b){
			return a;
		}else{
			return b;
		}
	}

	public static int max(int a, int b) {
		// TODO Auto-generated method stub
		if(a>b){
			return a;
		}else{
			return b;
		}
	}

}
