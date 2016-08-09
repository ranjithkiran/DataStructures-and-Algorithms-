package com.prac.dp;

public class countBinStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("value is"+countStrings(5));
	}

	public static int countStrings(int length) {
		// TODO Auto-generated method stub
		if(length<=0)
			return 0;
		if(length==1)
			return 2;
		if(length==2)
			return 3;
		return countStrings(length-1)+countStrings(length-2);
	}

}
