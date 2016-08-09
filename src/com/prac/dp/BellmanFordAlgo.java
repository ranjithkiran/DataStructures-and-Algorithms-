package com.prac.dp;

class Graph
{
    // A class to represent a weighted edge in graph
    class Edge {
        int src, dest, weight;
        Edge() {
            src = dest = weight = 0;
        }
    };
 
    int V, E;
    Edge edge[];
 
    // Creates a graph with V vertices and E edges
    Graph(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
}

public class BellmanFordAlgo {
	
	

		public  void BellmanFord(Graph graph, int src) {
			// TODO Auto-generated method stub
			int dist[]=new int[graph.V];
			for(int i=0;i<graph.V;i++){
				dist[i]=Integer.MAX_VALUE;
			}
			dist[src]=0;
			for(int i=0;i<graph.V;i++){
				for(int j=0;j<graph.E;j++){
					int src1=graph.edge[j].src;
					int dest1=graph.edge[j].dest;
					int weight=graph.edge[j].weight;
					if(dist[src1]!=Integer.MAX_VALUE && dist[src1]+weight<dist[dest1]){
						dist[dest1]=dist[src1]+weight;
					}
				}
			}
			
			for (int j=0; j<graph.E; ++j)
	        {
	            int u = graph.edge[j].src;
	            int v = graph.edge[j].dest;
	            int weight = graph.edge[j].weight;
	            if (dist[u]!=Integer.MAX_VALUE &&
	                dist[u]+weight<dist[v])
	              System.out.println("Graph contains negative weight cycle");
	        }
			printArr(dist, graph.V);
		}

		public void printArr(int[] dist, int v2) {
			// TODO Auto-generated method stub
			 System.out.println("Vertex   Distance from Source");
		        for (int i=0; i<v2; ++i)
		            System.out.println(i+"\t\t"+dist[i]);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5;  // Number of vertices in graph
        int E = 8;  // Number of edges in graph
 
        Graph graph = new Graph(V, E);
 
        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;
 
        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;
 
        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;
 
        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;
 
        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;
 
        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;
 
        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;
 
        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;
        BellmanFordAlgo algo=new BellmanFordAlgo();
 
        algo.BellmanFord(graph, 0);
	 
	}

}
