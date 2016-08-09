package com.prac.greedy;

class MST{
	public static final int vertices=5;
	public MST(){
		
	}
	
	public int minkey(int key[],boolean mstset[]){
		int max=Integer.MAX_VALUE;
		int min_idx = 0;
		for(int i=0;i<vertices;i++){
			if(mstset[i]==false && key[i]<max){
				max=key[i];
				min_idx=i;
			}
		}
		return min_idx;
	}
	
	public static void printMST(int parent[], int n, int graph[][])
    {
        System.out.println("Edge   Weight");
        for (int i = 1; i < vertices; i++)
            System.out.println(parent[i]+" - "+ i+"    "+
                               graph[i][parent[i]]);
    }
	
	public void primMST(int graph[][]){
		int key[]=new int[vertices];
		int parent[]=new int[vertices];
		boolean mstset[]=new boolean[vertices];
		for(int i=0;i<vertices;i++){
			key[i]=Integer.MAX_VALUE;
			mstset[i]=false;
		}
		key[0]=0;
		parent[0]=-1;
		for(int j=0;j<vertices;j++){
			int min_idx=minkey(key,mstset);
			mstset[min_idx]=true;
			for(int i=0;i<vertices;i++){
				if(graph[min_idx][i]!=0 && mstset[i]==false && graph[min_idx][i] <  key[i]){
					parent[i]=min_idx;
					key[i]=graph[min_idx][i];
				}
			}
		}
		printMST(parent, vertices, graph);
		
	}
}

public class PrimsMST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = new int[][] {{0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0},
           };
           MST t=new MST();
           t.primMST(graph);
	}

}
