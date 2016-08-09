package com.prac.greedy;

import java.util.*;
import java.lang.*;
import java.io.*;

class GraphMST{
	class Edge implements Comparable<Edge>{
        int src,dest,weight;
		@Override
		public int compareTo(Edge arg0) {
			// TODO Auto-generated method stub
			return this.weight-arg0.weight;
		}
	}
	
	class Subset{
		int parent;
		int rank;
	}
	
	int vertex,edges;
	Edge edge[];
	public GraphMST(int vertex,int edgecount){
		this.vertex=vertex;
		this.edges=edgecount;
		this.edge=new Edge[edgecount];
		for(int i=0;i<edges;i++){
			edge[i]=new Edge();
		}
	}
	
	int find(Subset[] set,int i){
		if(set[i].parent!=i){
			return find(set,set[i].parent);
		}
		return set[i].parent;
	}
	
	void Union(Subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
 
        // If ranks are same, then make one as root and increment
        // its rank by one
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
	
	void KruskalMST(){
		Edge result[] = new Edge[vertex];  // Tnis will store the resultant MST
        int e = 0;  // An index variable, used for result[]
        int i = 0;  // An index variable, used for sorted edges
        for (i=0; i<vertex; ++i){
            result[i] = new Edge();
        }
        Arrays.sort(edge);
        Subset set[]=new Subset[vertex];
        for(int j=0;j<vertex;j++){
        	set[j]=new Subset();
        	set[j].parent=j;
        	set[j].rank=0;
        }
        
        while(e<vertex-1){
        	Edge next_edge=new Edge();
        	next_edge=edge[e];
        	int x=find(set,next_edge.src);
        	int y=find(set,next_edge.dest);
        	if(x!=y){
        		result[e]=next_edge;
        		Union(set, x, y);
        	}
        	e++;
        }
        
        System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i <e; ++i){
        	 System.out.println(result[i].src+" -- "+result[i].dest+" == "+
                     result[i].weight);	
        }
  }
}

public class KruskalsMST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int V = 4;  // Number of vertices in graph
	     int E = 5;  // Number of edges in graph
	     GraphMST graph = new GraphMST(V, E);
	        // add edge 0-1
	        graph.edge[0].src = 0;
	        graph.edge[0].dest = 1;
	        graph.edge[0].weight = 10;
	 
	        // add edge 0-2
	        graph.edge[1].src = 0;
	        graph.edge[1].dest = 2;
	        graph.edge[1].weight = 6;
	 
	        // add edge 0-3
	        graph.edge[2].src = 0;
	        graph.edge[2].dest = 3;
	        graph.edge[2].weight = 5;
	 
	        // add edge 1-3
	        graph.edge[3].src = 1;
	        graph.edge[3].dest = 3;
	        graph.edge[3].weight = 15;
	 
	        // add edge 2-3
	        graph.edge[4].src = 2;
	        graph.edge[4].dest = 3;
	        graph.edge[4].weight = 4;
	        graph.KruskalMST();
	}

}
