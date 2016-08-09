package com.prac.dp;

public class MobileKeypad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int keypad[][] = {{'1','2','3'},
                 {'4','5','6'},
                 {'7','8','9'},
                 {'*','0','#'}};
		 System.out.println("Count for numbers of length %d: %d\n"+ getCount(keypad, 1));
		 System.out.println("Count for numbers oflength %d: %d\n"+ getCount(keypad, 2));
		 System.out.println("Count for numbers of length %d: %d\n"+getCount(keypad, 3));
		 System.out.println("Count for numbers of length %d: %d\n" +getCount(keypad, 4));
		 System.out.println("Count for numbers of length %d: %d\n"+ getCount(keypad, 5));
	}

	public static int getCount(int[][] keypad, int n) {
		// TODO Auto-generated method stub
		if(keypad==null || n<=0)
			return 0;
		if(n==1)
			return 10;
		int totalcount=0;
		for(int i=0;i<keypad.length;i++){
			for(int j=0;j<keypad[0].length;j++){
				if(keypad[i][j]!='*' || keypad[i][j]!='#'){
					totalcount+=getCountUtil(keypad,i,j,n);
				}
			}
		}
		return totalcount;
	}

	public static int getCountUtil(int[][] keypad,int row,int column, int n) {
		// TODO Auto-generated method stub
		if(keypad==null ||n<=0)
			return 0;
		if(n==1)
			return 1;
		int rows[]={0,1,-1,0,0};
		int colums[]={0,0,0,1,-1};
		int count=0;
		int temprow=0;
		int tempcolumn=0;
		for(int move=0;move<5;move++){
		        temprow=row+rows[move];
		        tempcolumn=column+colums[move];
			if(temprow>=0 && temprow<keypad.length && tempcolumn>=0 && tempcolumn<keypad[0].length && keypad[temprow][tempcolumn]!='*' && keypad[temprow][tempcolumn]!='#'){
				count+=getCountUtil(keypad,temprow,tempcolumn,n-1);
			}
		}
		return count;
	}

}
