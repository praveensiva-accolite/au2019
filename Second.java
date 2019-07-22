package Assignments;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Second 
{

public static void main(String [] args)   
{
   Sort b1=new Sort ("chetan",120,1,"two states");
   Sort b2=new Sort ("chetan",210,2,"three idiots");
   Sort b3=new Sort ("chetan",330,3,"half girlfriend");
   Sort b4=new Sort ("roy",310,4,"god of small things");
   Sort b5=new Sort ("boy",120,5,"Annhilation of caste");
   Sort b6=new Sort ("kishore ",180,5,"half boyfriend");
   Sort b7=new Sort ("bond",420,6,"blue umbrella");
   Sort b8=new Sort ("bond",320,7,"cherry tree");
   Sort b9=new Sort ("ps",220,8,"life at MIT");
   
   ArrayList<Sort> list= new ArrayList<Sort>();
   
   list.add(b1);
   list.add(b2);
   list.add(b3);
   list.add(b4);
   list.add(b5);
   list.add(b6);
   list.add(b7);
   list.add(b8);
   list.add(b9);
   
   HashMap <String,Integer> hash= new HashMap<>();
   for(Sort b:list)
   {
	   String s=b.getAuthor();
		if(hash.containsKey(s))
			hash.put(s, hash.get(s) + 1);
		else
			hash.put(s, 1);	
   }
   
   for(Map.Entry<String,Integer> entry :hash.entrySet())
   {
	   if(entry.getValue() > 2)
	   {
		   System.out.println(entry.getKey());
	   }
   }
}
}