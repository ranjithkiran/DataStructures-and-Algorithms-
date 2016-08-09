package com.prac.dp;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	int size;
	public TreeNode(int data){
		this.data=data;
		this.left=null;
		this.right=null;
		this.size=0;
	}
}
public class LISet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root         = new TreeNode(20);
	    root.left                = new TreeNode(8);
	    root.left.left          = new TreeNode(4);
	    root.left.right         = new TreeNode(12);
	    root.left.right.left   = new TreeNode(10);
	    root.left.right.right  = new TreeNode(14);
	    root.right               = new TreeNode(22);
	    root.right.right        = new TreeNode(25);
	    System.out.println("Size of the Largest Independent Set is %d "+LISSDP(root));
	}

	public static int LISS(TreeNode root) {
		// TODO Auto-generated method stub
		int excl=0;
		if(root==null)
			return 0;
		excl+=LISS(root.left)+LISS(root.right);
		int incl=1;
		if(root.left!=null)
			incl+=LISS(root.left.right)+LISS(root.left.left);
		if(root.right!=null)
			incl+=LISS(root.right.left)+LISS(root.right.right);
		return max(incl,excl);
	}

	public static int max(int a, int b) {
		// TODO Auto-generated method stub
	    if(a>b)
	    	return a;
	    else
	    	return b;
	}
	
	public static int LISSDP(TreeNode root) {
		// TODO Auto-generated method stub
		
		if(root==null)
			return 0;
		
		if(root.size!=0)
			return root.size;
		
		int excl=0;
	    excl+=LISS(root.left)+LISS(root.right);
		
	    int incl=1;
		if(root.left!=null)
			incl+=LISS(root.left.right)+LISS(root.left.left);
		if(root.right!=null)
			incl+=LISS(root.right.left)+LISS(root.right.right);
		return root.size=max(incl,excl);
	}

}
