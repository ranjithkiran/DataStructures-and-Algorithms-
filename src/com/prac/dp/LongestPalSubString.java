package com.prac.dp;

public class LongestPalSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "forgeeksskeegfor";
	    System.out.println("max length is"+longestPalSubstr( str ));
	}

	private static int longestPalSubstr(String str) {
		// TODO Auto-generated method stub
		boolean temp[][]=new boolean[str.length()][str.length()];
		int max_length=1;
		int start=0;
		int end=0;
		for(int i=0;i<str.length();i++){
			temp[i][i]=true;
		}
		
		for(int l=2;l<=str.length();l++){
			for(int i=0;i<str.length()-l+1;i++){
				int j=i+l-1;
				if(l==2){
					if(str.charAt(i)==str.charAt(j)){
						temp[i][j]=true;
						if(max_length<l){
							max_length=l;
							start=i;
							end=j;	
						}
					}else{
						temp[i][j]=false;
					}
				}else{
					if(str.charAt(i)==str.charAt(j) && temp[i+1][j-1]){
						temp[i][j]=true;
						if(max_length<l){
							max_length=l;
							start=i;
							end=j;	
						}
					}else{
						temp[i][j]=false;
					}
				}
				
			}
		}
		return max_length;
	}

}
