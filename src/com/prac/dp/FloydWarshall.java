package com.prac.dp;

public class FloydWarshall {
	
	static int INF = 99999;

	public static void main (String[] args)
    {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
        int graph[][] = { {0,   5,  INF, 10},
                          {INF, 0,   3, INF},
                          {INF, INF, 0,   1},
                          {INF, INF, INF, 0}
                        };
        // Print the solution
        floydWarshall(graph);
    }

	public static void floydWarshall(int[][] graph) {
		// TODO Auto-generated method stub
		int dist[][]=new int[graph.length][graph.length];
		for(int i=0;i<graph.length;i++){
			for(int j=0;j<graph.length;j++){
				dist[i][j]=graph[i][j];
			}
		}
		for(int i=0;i<graph.length;i++){
			for(int j=0;j<graph.length;j++){
				for(int k=0;k<graph.length;k++){
					if(dist[j][i]+dist[i][k]<dist[j][k]){
						dist[j][k]=dist[j][i]+dist[i][k];
					}
				}
			}
		}
		System.out.println("Following matrix shows the shortest "+
                "distances between every pair of vertices");
		for (int i=0; i<graph.length; ++i)
		{
		   for (int j=0; j<graph.length; ++j)
		   {
		       if (dist[i][j]==INF)
		           System.out.print("INF ");
		       else
		           System.out.print(dist[i][j]+"   ");
		   }
		   System.out.println();
		}
	}

}
