package com.prac.greedy;

class ShortestPath{
	static final int V=9;
	
	public static int minValue(int dist[],boolean inc_set[]){
		int min=Integer.MAX_VALUE;
		int min_idx=0;
		for(int i=0;i<V;i++){
			if(inc_set[i]==false && dist[i]<min){
				min=dist[i];
				min_idx=i;
			}
		}
		return min_idx;
	}
	
	public static void dijkstra(int graph[][],int src){
		boolean inc_set[]=new boolean[V];
		int dist[]=new int[V];
		for(int i=0;i<V;i++){
			inc_set[i]=false;
			dist[i]=Integer.MAX_VALUE;
		}
		dist[src]=0;
		for(int i=0;i<V;i++){
			int dist_min_idx=minValue(dist,inc_set);
			inc_set[dist_min_idx]=true;
			for(int j=0;j<V;j++){
				if(inc_set[j]==false && graph[dist_min_idx][j]!=0 && dist[j]>dist[dist_min_idx]+graph[dist_min_idx][j]){
					dist[j]=dist[dist_min_idx]+graph[dist_min_idx][j];
				}
			}
		}
	    printSolution(dist, V);
	}

	public static void printSolution(int[] dist, int v2) {
		// TODO Auto-generated method stub
		System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" \t\t "+dist[i]);
	}
}

public class DijkstrasAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 0, 10, 0, 2, 0, 0},
            {0, 0, 0, 14, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
           };
         ShortestPath t = new ShortestPath();
         t.dijkstra(graph, 0);
	}

}
