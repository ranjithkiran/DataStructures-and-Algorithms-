package com.prac.greedy;

//Java Program for union-find algorithm to detect cycle in a graph
import java.util.*;
import java.lang.*;
import java.io.*;

class Edge{
	int src;
	int dest;
	public Edge(){
		
	}
}

class Graph{
	int vertices;
	int edges;
	Edge edge[];
	public Graph(int vertices,int edges){
		this.vertices=vertices;
		this.edges=edges;
		this.edge=new Edge[edges];
		for(int i=0;i<edges;i++){
			edge[i]=new Edge();
		}
	}
	
	public int find(int parent[],int i){
		if(parent[i]==-1)
			return i;
		else
			return find(parent,parent[i]);
	}
	
	public void Union(int parent[],int x, int y){
		int one=find(parent,x);
		int two=find(parent,y);
		parent[one]=two;
	}
	
	public int isCycle(Graph g){
		int parent[]=new int[g.vertices];
		for(int i=0;i<parent.length;i++){
			parent[i]=-1;
		}
		for(int i=0;i<g.edges;i++){
			int src=g.edge[i].src;
			int dest=g.edge[i].dest;
			int one=g.find(parent,src);
			int two=g.find(parent,dest);
			if(one==two)
				return 1;
			else{
				g.Union(parent, one, two);
			}
		}
		return 0;
	}
	
}
public class UnionFindAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 3, E = 3;
        Graph graph = new Graph(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
 
        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
 
        if (graph.isCycle(graph)==1)
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
	}

}
