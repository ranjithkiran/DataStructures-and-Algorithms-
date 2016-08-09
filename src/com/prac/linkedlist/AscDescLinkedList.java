package com.prac.linkedlist;

class ListNode{
	ListNode next;
	int data;
	public ListNode(int data){
		this.data=data;
		this.next=null;
	}
}

public class AscDescLinkedList {
   
	public static ListNode merge(ListNode first,ListNode second){
		
		if(first==null)
			return second;
		if(second==null)
		    return first;
		ListNode temp=null;
		if(first.data<second.data){
			temp=new ListNode(first.data);
			temp.next=merge(first.next,second);
		}
		
		if(first.data>second.data){
			temp=new ListNode(second.data);
			temp.next=merge(first,second.next);
		}
		
		if(first.data==second.data){
			temp=new ListNode(second.data);
			temp.next=merge(first.next,second.next);
		}
		return temp;
		
	}
	public static ListNode getMiddleNode(ListNode head){
		ListNode slow_ptr=head;
		ListNode prev=head;
		ListNode fast_ptr=head;
		while(fast_ptr!=null && fast_ptr.next!=null){
			prev=slow_ptr;
			slow_ptr=slow_ptr.next;
			fast_ptr=fast_ptr.next.next;
		}
		prev.next=null;
		return  slow_ptr;
	}
	
	public static ListNode reverse(ListNode head){
		ListNode tempstart;
		ListNode prev=null;
		ListNode current=head;
		ListNode nextnode=null;
		while(current!=null){
			nextnode=current.next;
			current.next=prev;
			prev=current;
			current=nextnode;
		}
		head=prev;
		return head;
	}
	
	public static ListNode AscDesc(ListNode head){
		if(head==null || head.next==null)
			return head;
		ListNode mid=getMiddleNode(head);
		ListNode node1=AscDesc(head);
		ListNode node2=AscDesc(mid);
		node2=reverse(node2);
		
		return merge(node1,node2);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(10);
	    head.next = new ListNode(40);
	    head.next.next = new ListNode(53);
	    head.next.next.next=new ListNode(30);
	    head.next.next.next.next =new ListNode(67);
	    head.next.next.next.next.next = new ListNode(12);
	    head.next.next.next.next.next.next = new ListNode(89);
	    ListNode headtemp=AscDesc(head);
	    while(headtemp!=null){
	    	System.out.println(headtemp.data);
	    	headtemp=headtemp.next;
	    }
	}

}
