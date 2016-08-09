package com.prac.linkedlist;

 class LinkedListNode{
	int data;
	LinkedListNode next;
	public LinkedListNode(int data){
		this.data=data;
		this.next=null;
	}
}

public class MergeLinkedList {
	
	public static LinkedListNode getMiddleNode(LinkedListNode head){
		LinkedListNode slowptr=head;
		LinkedListNode fastptr=head;
		LinkedListNode temp=head;
		while(fastptr!=null && fastptr.next!=null){
			temp=slowptr;
			slowptr=slowptr.next;
			fastptr=fastptr.next.next;
		}
		temp.next=null;
		return slowptr;
	}
	
	public static LinkedListNode merge(LinkedListNode first,LinkedListNode second){
		
		if(first==null)
			return second;
		if(second==null)
		    return first;
		LinkedListNode temp=null;
		if(first.data<second.data){
			temp=new LinkedListNode(first.data);
			temp.next=merge(first.next,second);
		}
		
		if(first.data>second.data){
			temp=new LinkedListNode(second.data);
			temp.next=merge(first,second.next);
		}
		
		if(first.data==second.data){
			temp=new LinkedListNode(second.data);
			temp.next=merge(first.next,second.next);
		}
		return temp;
		
	}
	
	public static  LinkedListNode  mergeSortList(LinkedListNode head) {
		
		if(head==null || head.next==null)
			return head;
		LinkedListNode mid=getMiddleNode(head);
		LinkedListNode head1=mergeSortList(head);
		LinkedListNode head2=mergeSortList(mid);
		
		return merge(head1,head2);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode n1 = new LinkedListNode(9);
		LinkedListNode n2 = new LinkedListNode(3);
		LinkedListNode n3 = new LinkedListNode(7);
 
		LinkedListNode n4 = new LinkedListNode(6);
		LinkedListNode n5 = new LinkedListNode(4);
		LinkedListNode n6 = new LinkedListNode(5);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		LinkedListNode temp=mergeSortList(n1);
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
	}

}
