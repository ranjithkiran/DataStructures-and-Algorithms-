package com.prac.greedy;

import java.util.*;
import java.lang.*;
import java.io.*;


class Subset
{
    int parent;
    int rank;
}

class EdgeRank{
	int src;
	int dest;
	public EdgeRank(){
		
	}
}
class GraphRank{
	int vertices;
	int edges;
	EdgeRank edge[];
	public GraphRank(int ver,int edg){
		this.vertices=ver;
		this.edges=edg;
		edge=new EdgeRank[edg];
		for(int i=0;i<edges;i++){
			edge[i]=new EdgeRank();
		}
	}
	
	public int find(Subset[] set,int element){
		if(set[element].parent!=element){
			return find(set,set[element].parent);
		}
		return set[element].parent;
    }
	
	public void union(Subset[] set,int src,int dest){
		int one=find(set,src);
		int two=find(set,dest);
		if(set[one].rank<set[two].rank){
			set[one].parent=two;
		}else if(set[one].rank>set[two].rank){
			set[two].parent=one;
		}else{
			set[one].parent=two;
			set[two].rank++;
		}
	}
	
	public int isCycle(GraphRank graph){
		int vertex=graph.vertices;
		Subset set[]=new Subset[vertex];
		for(int i=0;i<vertex;i++){
			set[i]=new Subset();
			set[i].parent=i;
			set[i].rank=0;
		}
		for(int i=0;i<graph.edges;i++){
			int one=graph.find(set,graph.edge[i].src);
			int two=graph.find(set,graph.edge[i].dest);
			if(one==two)
				return 1;
			else{
				graph.union(set, one, two);
			}
		}
		return 0;
	}
}

public class UnionFindAlgoByRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 3, E = 3;
		GraphRank graph = new GraphRank(V, E);
	    // add edge 0-1
	    graph.edge[0].src=0;
	    graph.edge[0].dest=1;
	 
	    // add edge 1-2
	    graph.edge[1].src = 1;
	    graph.edge[1].dest = 2;
	 
	    // add edge 0-2
	    graph.edge[2].src = 0;
	    graph.edge[2].dest = 2;
	    if(graph.isCycle(graph)==1){
	    	System.out.println("cycle exists");
	    }else{
	    	System.out.println("cycle does not exists");
	    }
	}

}
