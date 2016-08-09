package com.prac.dp;

public class CutRod {

	public static void main(String[] args){
        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "+ cutRodGEEKS(arr, size));
             
    }
	static int cutRodGEEKS(int price[], int n)
    {
       if (n <= 0)
         return 0;
       int max_val = Integer.MIN_VALUE;
      
       // Recursively cut the rod in different pieces and compare different 
       // configurations
       for (int i = 0; i<n; i++){
    	   max_val = max(max_val, price[i] + cutRodGEEKS(price, n-i-1));
       }
       return max_val;
    }
	private static int cutRod(int[] arr, int size) {
		// TODO Auto-generated method stub
		if(size<=0)
			return 0;
		int res=Integer.MIN_VALUE;
		for(int i=0;i<size;i++){
			res=max(res,arr[i]+cutRod(arr,size-i-1));
		}
		return res;
		
	}

	private static int max(int res, int i) {
		// TODO Auto-generated method stub
		if(res>i)
			return res;
		else
			return 1;
	}

}
