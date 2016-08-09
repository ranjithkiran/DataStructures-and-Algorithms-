package com.prac.dp;

public class LongestConsPath {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char mat[][] = { {'a','c','d'},
                { 'h','b','a'},
                { 'i','g','f'}};
		System.out.println(getLen(mat, 'a'));
		System.out.println(getLen(mat, 'e'));
		System.out.println(getLen(mat, 'b'));
		System.out.println(getLen(mat, 'f'));
	}
	public static boolean isValid(int row,int column,char mat[][]){
		if(row>=0 || row<mat[0].length || column>=0 || column<mat[0].length){
			return true;
		}
		return false;
	}
	
	private static boolean isAdjacent(char[][] mat, int row, int column, char ch) {
		// TODO Auto-generated method stub
		   if(isValid(row,column,mat)){
			   if(mat[row][column]-ch==1)
		    	   return true; 
		   }
		       return false;
	    }
	
   public static int getLenUtil(char mat[][],int row,int column,char ch){
	   if(!isValid(row, column, mat) ||!isAdjacent(mat,row,column,ch))
		   return 0;
	   int rows[]   ={1,-1,0,0,-1,-1,1,1};
	   int columns[]={0,0,1,-1,-1,1,1,-1};
	   int ans=0;
	   for(int move=0;move<8;move++){
		   ans=max(ans,1+getLenUtil(mat,row+rows[move],column+columns[move],ch));
	   }
	   return ans;
   }
	
	public static int getLen(char[][] mat, char c) {
		int rows[]   ={1,-1,0,0,-1,-1,1,1};
	    int columns[]={0,0,1,-1,-1,1,1,-1};
		// TODO Auto-generated method stub
	    int ans=0;
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				if(mat[i][j]==c){
					for(int move=0;move<8;move++){
						ans=max(ans,getLenUtil(mat,i+rows[move],j+columns[move],c));
					}
					
				}
			}
		}
		return ans;
	}
	private static int max(int a, int b) {
		// TODO Auto-generated method stub
		return (a>b)?a:b;
	}

}
