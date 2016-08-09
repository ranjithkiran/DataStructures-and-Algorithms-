package com.prac.dp;

import java.util.Arrays;
import java.util.Comparator;

class boxcomparator implements Comparator<Box>{
	@Override
	public int compare(Box o1, Box o2) {
		// TODO Auto-generated method stub
		int height1=o2.depth*o2.width;
		int height2=o1.depth*o1.width;
		return height1-height2;
	}
}

class Box  {
	int height;
	int width;
	int depth;
	public Box(){
		
	}
	public Box(int h,int w,int d){
		this.height=h;
		this.width=w;
		this.depth=d;
	}
	
	
}

public class BoxStacking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box[]=new Box[4];
		box[0]=new Box(4,6,7);
		box[1]=new Box(1,2,3);
		box[2]=new Box(4,5,6);
		box[3]=new Box(10,12,32);
		System.out.println("stack height is"+maxStackHeight(box,box.length));
	}

	private static int maxStackHeight(Box[] box, int length) {
		// TODO Auto-generated method stub
		Box boxobj[]=new Box[3*length];
		for(int i=0;i<3*length;i++){
			boxobj[i]=new Box();
		}
		
		int index=0;
		for(int i=0;i<length;i++){
			boxobj[index]=box[i];
			index++;
			boxobj[index].height=box[i].width;
			boxobj[index].width=min(box[i].height,box[i].depth);
			boxobj[index].depth=max(box[i].height,box[i].depth);
			index++;
			boxobj[index].height=box[i].depth;
			boxobj[index].width=min(box[i].height,box[i].width);
			boxobj[index].depth=max(box[i].height,box[i].width);
			index++;
		}
		Arrays.sort(boxobj,new boxcomparator());
		int dp[]=new int[3*length];
		for(int i=0;i<3*length;i++){
			dp[i]=boxobj[i].height;
		}
		
		for(int i=1;i<3*length;i++){
			for(int j=0;j<i;j++){
				if(boxobj[i].width<boxobj[j].width && boxobj[i].depth<boxobj[j].width && dp[i]<dp[j]+boxobj[j].height){
					dp[i]=dp[j]+boxobj[j].height;
				}
			}
		}
		int max=dp[0];
		for(int i=1;i<3*length;i++){
			if(dp[i]>max)
				max=dp[i];
		}
		return max;
		
	}

	private static int max(int a, int b) {
		// TODO Auto-generated method stub
		if(a>b)
			return a;
		else
			return b;
	}

	private static int min(int a, int b) {
		// TODO Auto-generated method stub
		if(a<b)
			return a;
		else
			return b;
	}

}
