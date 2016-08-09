package com.prac.string;

public class NaivePatternSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  txt= "AABAACAADAABAAABAA";
		String pat= "AABA";
		search(pat, txt);
	}

	private static void search(String pat, String txt) {
		// TODO Auto-generated method stub
		int txt_ptr=0;
		int pat_ptr=0;
		for(int i=0;i<=txt.length()-pat.length();i++){
			int j;
			for(j=0;j<pat.length();j++){
				if(txt.charAt(i+j)!=pat.charAt(j)){
					break;
				}
			}
			if(j==pat.length()){
				System.out.println("pattern found at index"+i);
			}
		}
	}

}
