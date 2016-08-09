package com.prac.greedy;

import java.util.Arrays;

public class MinNoOfPlatforms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
	    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
	    Arrays.sort(arr);
	    Arrays.sort(dep);
	    int no_of_platforms=1;
	    int arr_ptr=1;
	    int dep_ptr=0;
	    int result=1;
	    System.out.println(no_of_platforms+" platform occupied between "+arr[arr_ptr-1]+" and "+dep[dep_ptr]);
	    while(arr_ptr<arr.length && dep_ptr<arr.length){
	    	if(arr[arr_ptr]>dep[dep_ptr]){
	    		no_of_platforms--;
	    		System.out.println(no_of_platforms+" platform occupied between "+dep[dep_ptr]+" and "+arr[arr_ptr]);
	    		dep_ptr++;
	    	}else{
	    		no_of_platforms++;
	    		System.out.println(no_of_platforms+" platform occupied between "+arr[arr_ptr]+" and "+dep[dep_ptr]);
	    		if(no_of_platforms>result){
	    			result=no_of_platforms;
	    		}
	    		arr_ptr++;
	    	}
	    }
	    System.out.println("max_no_platforms needed is"+result);
	}

}
