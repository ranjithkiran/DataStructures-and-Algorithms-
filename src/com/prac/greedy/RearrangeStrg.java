package com.prac.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class HeapNode implements Comparable<HeapNode>{
	char ch;
	int count;
	public HeapNode(char ch,int count){
		this.ch=ch;
		this.count=count;
	}
	@Override
	public int compareTo(HeapNode node) {
		// TODO Auto-generated method stub
		return node.count-this.count;
	}
}

public class RearrangeStrg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    String temp = "geeksforgeeks";
		    String tempone=rearrange(temp, 3);
		    System.out.println(rearrange(temp, 3));
	}

	public static String rearrange(String temp, int dist) {
		// TODO Auto-generated method stub
		String tempone=temp;
		Map<Character,Integer> map=new HashMap();
		for(int i=0;i<temp.length();i++){
			if(map.get(temp.charAt(i))==null){
				map.put(temp.charAt(i),1);
			}else{
				int count=map.get(temp.charAt(i));
				map.put(temp.charAt(i),count+1);
			}
		}
		Set<Character> set=map.keySet();
		Queue<HeapNode> queue=new PriorityQueue();
		for(Character ch:set){
			HeapNode heap=new HeapNode(ch,map.get(ch));
			queue.add(heap);
		}
		int ptr=0;
		char[] charr=tempone.toCharArray();
		while(!queue.isEmpty()){
			HeapNode temp1=queue.poll();
			char ch=temp1.ch;
			int count=temp1.count;
			int var=ptr;
			while(count>=0 && var<tempone.length()){
				charr[var]=ch;
				var=var+dist;
			}
			ptr++;
		}
		return new String(charr);
	}

}
