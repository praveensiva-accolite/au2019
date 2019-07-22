package Assignments;

import java.util.*;

class Uniqueelements 
{
	
		
	public static void main (String[]args)
	{
    HashSet<String> h1=new HashSet<>();
    String [] s1=new String [] {"Hello", "This", "is", "Java"};
    String [] s2=new String [] {"Hello", "Java", "folks"};
    
    for(int i=0;i<s1.length;i++)
    {
    	h1.add(s1[i]);
    }
    for(int i=0;i<s2.length;i++)
    {
    	if(h1.contains(s2[i]))
    	{
    		System.out.println(s2[i]);
    	}
    }
}
}
