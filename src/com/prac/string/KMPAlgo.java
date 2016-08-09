package com.prac.string;

public class KMPAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt = "ABABDABACDABABCABAB";
	    String pat = "ABABCABAB";
	    KMPSearch(pat,txt);
	}

	private static void KMPSearch(String pat, String txt) {
		// TODO Auto-generated method stub
		int patlen=pat.length();
		int txtlen=txt.length();
		int lps[]=new int[patlen];
		computeLPSArray(pat,lps);
		int patptr=0;
		int txtptr=0;
		while(txtptr<txtlen){
			if(pat.charAt(patptr)==txt.charAt(txtptr)){
				patptr++;
				txtptr++;
			}
			if(patptr==patlen){
				System.out.println("pattern found at"+(txtptr-patptr));
				patptr=lps[patptr-1];
			}
			if(txtptr<txtlen && pat.charAt(patptr)!=txt.charAt(txtptr)){
				if(patptr!=0){
					patptr=lps[patptr-1];
				}
				else{
					txtptr++;
				}
			}
		}
	}

	private static void computeLPSArray(String pat, int lps[]) {
		// TODO Auto-generated method stub
		int i=0;
		int j=1;
		lps[i]=0;
		while(j<pat.length()){
			if(pat.charAt(i)==pat.charAt(j)){
				i++;
				j++;
				lps[i]=i;
			}
			else{
				if(i!=0){
					i=lps[j-1];
				}else{
					lps[j]=i;
					j++;
				}
			}
		}
	}

}
