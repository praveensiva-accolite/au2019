package Assignments;

import java.util.*;

class Sortbyprice implements Comparator <Sort>
{
	public int compare(Sort obj1,Sort obj2)
	{
		return obj1.price - obj2.price;
	}
}
public class Sort
{
    String author;
    public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	int price ;
    int isbn;
    String bookname;
    
    Sort(String author,int price,int isbn,String bookname)
    {
    	this.author=author;
    	this.price=price;
    	this.isbn=isbn;
    	this.bookname=bookname;
    }
    
    public String toString() 
    { 
        return this.author + " " + this.price + 
                           " " + this.isbn+" "+this.bookname; 
    } 
    public static void main(String [] args)
    {
        ArrayList<Sort> list1=new ArrayList <Sort>();
       list1.add(new Sort("chetan",120,1,"two states"));
       list1.add(new Sort("chetan",210,2,"three idiots"));
       list1.add(new Sort("chetan",330,3,"half girlfriend"));
       list1.add(new Sort("roy",310,4,"god of small things"));
       list1.add(new Sort("boy",120,5,"Annhilation of caste"));
       list1.add(new Sort("kishore ",180,5,"half boyfriend"));
       list1.add(new Sort("bond",420,6,"blue umbrella"));
       list1.add(new Sort("bond",320,7,"cherry tree"));
       list1.add(new Sort("ps",220,8,"life at MIT"));
       
      
       Collections.sort(list1,new Sortbyprice());
       
       for(int i=0;i<list1.size();i++)
       {
          System.out.println(list1.get(i));
       }
    }
}
