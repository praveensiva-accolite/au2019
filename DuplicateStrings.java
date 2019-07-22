package Assignments;

import  java.util.*;

public class DuplicateStrings
{

	public static void main(String []args)
	{
		HashMap<String,Integer>h1=new HashMap<>();
		String [] s1=new String[] {"tables", "chairs", "sofa", "tables", "fans","lights", "beds", "mattress", "beds"};
		for(int i=0;i<s1.length;i++)
		{
			//h1[s1[i]]++;
			h1.putIfAbsent(s1[i],0);
			h1.put(s1[i], h1.get(s1[i]) +1);
		}
		sortbyKey(h1);
		//print(h1);
	}

	private static void sortbyKey(HashMap<String, Integer> h1) 
	{
		// TODO Auto-generated method stub
		TreeMap <String,Integer> sorted=new TreeMap<String,Integer>();
		
		sorted.putAll(h1);
		
		// used treemap
		String result[];
		 for (Map.Entry<String, Integer> entry : sorted.entrySet())  
		 {
			 if(entry.getValue() > 1)
	            System.out.println(entry.getKey() );  
		// result[i++]=entry.getKey();
		 }
	}

	private static void print(HashMap<String, Integer> h1) 
	{
		// TODO Auto-generated method stub
		if(h1.isEmpty())
		{
			return;
		}
		
		System.out.println(h1);
	}
}
