package com.prac.dp;

public class LargeSumCont {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		int max_sum = maxSubArraySum(a, a.length);
		System.out.println("Maximum contiguous sum is "+max_sum);
	}

	public static int maxSubArraySum(int[] a, int length) {
		// TODO Auto-generated method stub
		int max_so_far=a[0];
		int max_sum=Integer.MIN_VALUE;
		int start=0;
		int end=0;
		for(int i=1;i<a.length;i++){
			if(max_so_far+a[i]<a[i]){
				start=i;
			}
			max_so_far=max(max_so_far+a[i],a[i]);
			if(max_so_far>max_sum){
				max_sum=max_so_far;
				end=i;
			}
				
		}
		System.out.println("start value is"+start+"and end value is"+end);
		return max_sum;
	}

	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		return (i>j)?i:j;
	}

}
