package com.prac.array;

public class CmnElement3Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar1[] = {1, 5, 10, 20, 40, 80};
        int ar2[] = {6, 7, 20, 80, 100};
        int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};
 
        System.out.print("Common elements are ");
        findCommon(ar1, ar2, ar3);
	}

	private static void findCommon(int[] ar1, int[] ar2, int[] ar3) {
		// TODO Auto-generated method stub
		int first_idx=0;
		int second_idx=0;
		int third_idx=0;
		while(first_idx<ar1.length && second_idx<ar2.length && third_idx<ar3.length){
			if(ar1[first_idx]==ar2[second_idx] && ar2[second_idx]==ar3[third_idx]){
				System.out.println(ar1[first_idx]);
				first_idx++;
				second_idx++;
				third_idx++;
			}
			if(first_idx<=ar1.length-1 && ar1[first_idx]<ar2[second_idx]){
				first_idx++;
			}
			else if(second_idx<=ar2.length-1 && ar2[second_idx]<ar3[third_idx]){
				second_idx++;
			}
			else
				third_idx++;
		}
	}

}
