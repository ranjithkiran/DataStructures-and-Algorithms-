package com.prac.dp;

public class wordbreak {
	
	public static boolean contains(String str){
		String dictionary[] = {"mobile","samsung","sam","sung","man","mango","icecream","and","go","i","like","ice","cream"};
		for(int i=0;i<dictionary.length;i++){
			if(str.compareTo(dictionary[i])==0)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(wordBreak("ilikesamsung"));
		 System.out.println(wordBreak("iiiiiiii"));
		 System.out.println(wordBreak("ilikelikeimangoiii"));
		 System.out.println(wordBreak("samsungandmango"));
		 System.out.println(wordBreak("samsungandmangok"));
		 
	}

	public static boolean wordBreak(String string) {
		// TODO Auto-generated method stub
		if (string.length()==0)
			return true;
		for(int i=1;i<=string.length();i++){
			if(wordbreak.contains(string.substring(0, i))&& wordBreak(string.substring(i))){
				return true;
			}
		}
		return false;
	}
	
	

}
