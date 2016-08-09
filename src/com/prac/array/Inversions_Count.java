package com.prac.array;

public class Inversions_Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {8, 4, 2, 1};
		System.out.println(" Number of inversions are %d \n"+mergeSort(arr,0,arr.length-1));
	}

	public static int mergeSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int inv_count=0;
		if(low<high){
			
			int mid=(low+high)/2;
			inv_count+=mergeSort(arr,low,mid);
			inv_count+=mergeSort(arr,mid+1,high);
			inv_count+=merge(arr,low,mid,high);
			return inv_count;
		}
		return 0;
	}

	public static int merge(int[] arr, int low, int mid, int high) {
		// TODO Auto-generated method stub
		int inv_count=0;
		int fir_strt=low;
		int fir_end=mid;
		int sec_strt=mid+1;
		int sec_end=high;
		int temp_Strt=0;
		int temp[]=new int[(high-low)+1];
		while(fir_strt<=fir_end && sec_strt<=sec_end){
			if(arr[fir_strt]<=arr[sec_strt]){
				temp[temp_Strt]=arr[fir_strt];
				temp_Strt++;
				fir_strt++;
			}else{
				inv_count+=mid-fir_strt+1;
				temp[temp_Strt]=arr[sec_strt];
				temp_Strt++;
				sec_strt++;
			}
		}
		if(fir_strt>fir_end){
			while(sec_strt<=sec_end){
				temp[temp_Strt]=arr[sec_strt];
				temp_Strt++;
				sec_strt++;
			}
		}
		if(sec_strt>sec_end){
			while(fir_strt<=fir_end){
				temp[temp_Strt]=arr[fir_strt];
				temp_Strt++;
				fir_strt++;
			}
		}
		for(int i=0;i<temp_Strt;i++){
			arr[low+i]=temp[i];
		}
		for(int i=low;i<=high;i++){
			System.out.println(arr[i]);
		}
		return inv_count;
	}

}
