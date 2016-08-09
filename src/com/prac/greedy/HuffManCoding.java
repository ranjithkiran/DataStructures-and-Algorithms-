package com.prac.greedy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class CharFreq implements Comparable<CharFreq>{
    char ch;
    int freq;
    StringBuilder Huffmancode;
    CharFreq left;
    CharFreq right;
    public CharFreq(char ch,int freq){
    	this.ch=ch;
    	this.freq=freq;
    	this.left=null;
    	this.right=null;
    }
    
    public CharFreq(int freq,CharFreq left,CharFreq right){
    	this.left=left;
    	this.right=right;
    	this.freq=freq;
    }
    
    public boolean isLeafode(){
    	return left==null && right==null;
    }
    
	@Override
	public int compareTo(CharFreq chf) {
		// TODO Auto-generated method stub
		return this.freq-chf.freq;
	}
	
}

public class HuffManCoding {

	public static void main(String[] args) {
		char[] ch = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] freq = { 5, 9, 12, 13, 16, 45 };
		CharFreq[] charFreq = new CharFreq[ch.length];
		for (int i = 0; i < ch.length; i++) {
			charFreq[i] = new CharFreq(ch[i], freq[i]);
		}
		Queue<CharFreq> queue=buildHuffManTree(charFreq);
		StringBuilder str=new StringBuilder();
		assignHuffManCoding(queue.peek(),str);
		CharFreq root=queue.peek();
		System.out.println("\n===================================");
		System.out.println("HuffMan code calculated for each character are as ");
		
		
}

	public static Queue<CharFreq> buildHuffManTree(CharFreq[] charFreq) {
		// TODO Auto-generated method stub
		Queue<CharFreq> queue=new PriorityQueue();
		for(int i=0;i<charFreq.length;i++){
			queue.add(charFreq[i]);
		}
		while(queue.size()>=2){
			CharFreq one=queue.poll();
			CharFreq two=queue.poll();
			CharFreq latest=new CharFreq(one.freq+two.freq,one,two);
			queue.add(latest);
			
		}
		return queue;
	}
	
	public static void assignHuffManCoding(CharFreq root,StringBuilder str){
		if(root==null)
			return;
		if(root.isLeafode()){
			System.out.println("character"+root.ch+" "+"code is"+str);
			root.Huffmancode=str;
			return;
		}
		assignHuffManCoding(root.left,str.append("0"));
		str.deleteCharAt(str.length()-1);
		assignHuffManCoding(root.right,str.append("1"));
		str.deleteCharAt(str.length()-1);
	}
}

