package Stack;

import java.util.*;
public class Linkedhash
{
	int i;
   int []keys;
   String []values;
   
   public Linkedhash(int size)
   {
	   keys=new int[size];
	   values=new String[size];
	   i=0;
   }
   
   public void put(int key,String val)
   {
	   keys[i]=key;values[i]=val;
	   i++;
   }
   
   public void get(int getval)
   {
	   boolean flag=false;
	   for(int j=0;j<i;j++)
	   {
		   if(keys[j] == getval)
		   {
			   System.out.println(values[j]);
			   flag=true; break;
		   }
	   }
	   if(!flag) 
	   {
		   System.out.println("The key is invalid");
	   }
	   
   }
   
   public void delete(int deletekey)
   {
	   boolean flag=false;
	   for(int j=0;j<i;j++)
	   {
		   if(keys[j]==deletekey)
		   {
			   flag=true;
			   while(j<i)
			   {
				   if(j+1 == i)
				   {
					   i=j;
					   break;
				   }
				   keys[j]=keys[j+1];
				   values[j]=values[j+1];
				   j++;
			   }
		   }
	   }
	   
	   if(!flag) 
	   {
           System.out.println("invalid key ");
	   }
   }
   
   public void display()
   {
	   for(int j=0;j< i;j++)
	   {
		   System.out.println( keys[j] + values[j] );
	   }
   }
   
   public static void main(String args[])
   {
	   Linkedhash lhp=new Linkedhash(10);
	   while(true)
	   {
		   System.out.println("enter 1 for put");
    	   System.out.println("enter 2 for delete");
    	   System.out.println("enter 3 for get");
    	   System.out.println("enter 4 for display");
		   int choice;
		   Scanner sc =new Scanner(System.in);
		   choice=sc.nextInt();
		   switch(choice)
		   {
		    case 1:
		    	 System.out.println("enter key and value to put");
		    	 int key;
		    	 String value;
		    	 key=sc.nextInt();
		    	 value=sc.nextLine();
		    	 lhp.put(key,value); break;
		    case 2:
		    	 System.out.println("enter key to be deleted ");
		    	 int deletekey;
		    	 deletekey=sc.nextInt();
		    	 lhp.delete(deletekey);
		    	 break;
		    case 3:
		    	 System.out.println("enter the key to get ur value");
		    	 int getval;
		    	getval= sc.nextInt();
		    	 lhp.get(getval); break;
		    case 4:
		    	lhp.display(); break;
		    default : 
		    	System.out.println("program terminated");
			      System.exit(1);;
			   
		   }
	   }
   }
}
