package com.prac.greedy;

import java.util.Arrays;

class Job implements Comparable<Job>{
	char id;      // Job Id
	int dead;    // Deadline of job
	int profit; 
	public Job(char id,int dead,int profit){
		this.id=id;
		this.dead=dead;
		this.profit=profit;
	}
	@Override
	public int compareTo(Job job) {
		// TODO Auto-generated method stub
		return job.profit-this.profit;
	}
}


public class JobScheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Job arr[] = new Job[5];
		arr[0]=new Job('a',2,100);
		arr[1]=new Job('b',1,19);
		arr[2]=new Job('c',2,27);
		arr[3]=new Job('d',1,25);
		arr[4]=new Job('e',3,15);
		printJobScheduling(arr,arr.length);
	}

	public static void printJobScheduling(Job[] arr, int len) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		int result[]=new int[len];
		boolean slot[]=new boolean[len];
		for(int i=0;i<len;i++){
			slot[i]=false;
		}
		for(int i=0;i<len;i++){
			int slot_idx=arr[i].dead;
			while((slot_idx-1)>=0){
				if(slot[slot_idx-1]==false){
					result[slot_idx-1]=i;
					slot[slot_idx-1]=true;
					break;
				}
				slot_idx-=1;
			}
		}
		for(int i=0;i<len;i++){
			if(slot[i]){
				System.out.println(arr[result[i]].id);
			}
		}
	}

}
