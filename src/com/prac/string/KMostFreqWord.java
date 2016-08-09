package com.prac.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class KMostFreqWord {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file=new File("C:/Users/WELCOME/Desktop/kmostfreqfile.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br =new BufferedReader(fr);
		String tempstring="";
		String str="";
		while((str=br.readLine())!=null){
			tempstring=tempstring+str;
		}
		System.out.println(tempstring);
		int k=5;
		getKMostFreqWords(tempstring,k);
		
	}

	public static void getKMostFreqWords(String temp,int k) {
		// TODO Auto-generated method stub
		String temparr[]=temp.split(" ");
		Map<String,Integer> map=new HashMap();
		int count=0;
		while(count<temparr.length){
			if(map.get(temparr[count])==null){
				map.put(temparr[count], 1);
			}else{
				int countone=map.get(temparr[count]);
				map.put(temparr[count],countone+1);
			}
			count++;
		}
		Map<String,Integer> tempone=sortMapByValue(map);
		Set<String> set=tempone.keySet();
		int count1=1;
		for(String temp1:set){
			System.out.println("key is "+temp1+" and value is "+tempone.get(temp1));
			if(count1==k)
				break;
			count1++;
			
		}
		
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String,Integer> sortMapByValue(Map<String,Integer> map){
	    List<Map.Entry<String, Integer>> list=new ArrayList(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue()-o1.getValue();
			}

			
			
		});
		Iterator itr=list.iterator();
		Map<String,Integer> tempmap=new LinkedHashMap<>();
		while(itr.hasNext()){
			Map.Entry<String, Integer> etr=(Map.Entry<String,Integer>)itr.next();
			tempmap.put(etr.getKey(), etr.getValue());
		}
		return tempmap;
	}

}
