package com.prac.greedy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GraphNode{
	int vertices;
	List<Integer> list[];
	public GraphNode(int vertices){
		this.vertices=vertices;
		list=new ArrayList[vertices];
		for(int i=0;i<vertices;i++){
			list[i]=new ArrayList();
		}
	}
	
	public void addEdge(int x,int y){
		list[x].add(y);
		list[y].add(x);
	}
	
	public  void greedyColoring(){
		boolean used_colors[]=new boolean[vertices];
		int result[]=new int[vertices];
		for(int i=0;i<vertices;i++){
			result[i]=-1;
			used_colors[i]=false;
		}
		result[0]=0;
		for(int i=1;i<vertices;i++){
			Iterator itr=this.list[i].iterator();
			while(itr.hasNext()){
				int idx=(int) itr.next();
				if(result[idx]!=-1){
					used_colors[result[idx]]=true;
				}
			}
			for(int j=0;j<vertices;j++){
				if(used_colors[j]==false){
					result[i]=j;
					break;
				}
			}
			itr=this.list[i].iterator();
			while(itr.hasNext()){
				int idx=(int) itr.next();
				if(result[idx]!=-1){
					used_colors[idx]=false;
				}
			}
			
			
		}
		for(int k=0;k<vertices;k++){
			System.out.println("vertex is"+k+" "+" and color is"+result[k]);
		}
		
	}
	
}
public class GraphColoring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphNode g1 = new GraphNode(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of graph 1");
        g1.greedyColoring();
	}

}
