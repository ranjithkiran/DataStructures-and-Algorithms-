package com.prac.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class PqComparator implements Comparator<Element>{

	@Override
	public int compare(Element o1, Element o2) {
		// TODO Auto-generated method stub
		return o1.data-o2.data;
	}

	
}

class Element{
	int data;
	int row;
	int column;
	public Element(int data,int row,int coulmn){
		this.data=data;
		this.row=row;
		this.column=column;
	}
	
}

class HeapNode {
    int data, r, c;

    public HeapNode() {
        this.data = data;
        this.r = r;
        this.c = c;
    }

    public HeapNode(HeapNode node) {
        this.data = node.data;
        this.r = node.r;
        this.c = node.c;
    }

}
public class kthSmallestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {{10, 20, 30, 40},{15, 25, 35, 45},{25, 29, 37, 48},{32, 33, 39, 50}};
		System.out.println("kth smallest value is"+kthSmallest(mat,4,7));
	}

	public static int kthSmallest(int[][] mat, int n, int k) {
		if (k <= 0 || k > n*n) {
            return Integer.MAX_VALUE;
        }

        HeapNode[] nodeArr = new HeapNode[n];
        for (int i = 0; i < n; i++) {
            nodeArr[i] = new HeapNode();
            nodeArr[i].data = mat[0][i];
            nodeArr[i].r = 0;
            nodeArr[i].c = i;
        }
       
       HeapNode hr = new HeapNode();
        for (int i = 0; i < k; i++) {
            hr = new HeapNode(nodeArr[0]);
            int nextVal = (hr.r < (n - 1) ? mat[hr.r + 1][hr.c]: Integer.MAX_VALUE);

            nodeArr[0].data = nextVal;
            nodeArr[0].r = hr.r + 1;
            nodeArr[0].c = hr.c;
           
        }

        return hr.data;
	}

}
