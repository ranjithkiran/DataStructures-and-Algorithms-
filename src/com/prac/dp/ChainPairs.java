package com.prac.dp;

class chain{
	int one;
	int two;
	public chain(int a,int b){
		this.one=a;
		this.two=b;
	}
}

public class ChainPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 chain[] temp= new chain[4];
		 temp[0]=new chain(5,24);
		 temp[1]=new chain(15,25);
		 temp[2]=new chain(27,40);
		 temp[3]=new chain(50,60);
		 System.out.println("Length of maximum size chain is %d\n"+maxChainLength(temp,temp.length));
	}

	public static int maxChainLength(chain[] temp, int length) {
		// TODO Auto-generated method stub
		int dp[]=new int[temp.length];
		for(int i=0;i<length;i++){
			dp[i]=1;
		}
		for(int i=1;i<length;i++){
			for(int j=0;j<i;j++){
				if(temp[j].two<temp[i].one && dp[i]<dp[j]+1){
					dp[i]=dp[j]+1;
				}
			}
		}
		int max=dp[0];
		for(int i=1;i<length;i++){
			if(dp[i]>max)
				max=dp[i];
		}
		return max;
	}

}
