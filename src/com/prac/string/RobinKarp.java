package com.prac.string;

public class RobinKarp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String txt= "GEEKS FOR GEEKS";
		 String pat= "GEEK";
		 int q = 101; // A prime number
		 search(pat, txt, q);
	}

	private static void search(String pat, String txt, int q) {
		// TODO Auto-generated method stub
		int M = pat.length();
	    int N = txt.length();
	    int i, j;
	    int p = 0; // hash value for pattern
	    int t = 0; // hash value for txt
	    int h = 1;
	    for(int k=0;k<pat.length();k++){
	    	p+=((int)(pat.charAt(k)))*Math.pow(q,k);
	    	
	    }
	    p=p%q;
	    for(int m=0;m<M;m++){
    		t+=((int)(txt.charAt(m)))*Math.pow(q,m);
    		
    	}
	    t=t%q;
	    if(t==p){
	    	System.out.println("pattern found at"+0+"index");
	    }
	    int prev_char=txt.charAt(0);
	    for(int k=1;k<=N-M;k++){
	    	int newhash=t-((int)(prev_char)%q);
	    	newhash=newhash/q;
	    	//newhash=newhash+(Math.pow(q, M-1)*(int)(txt.charAt(k)));
	    	if(newhash==p){
	    		int temp=0;
	    		for(int l=0;l<M;l++){
	    			if(txt.charAt(k+l)!=pat.charAt(l))
	    				break;
	    			else{
	    				temp++;
	    			}
	    		}
	    		if(temp==M){
	    			System.out.println("pattern found at index"+k);
	    		}
	    	}
	    	
	    }
	}

}
