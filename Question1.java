package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class Employe 
{
  
   private String ename;
   public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getSal() {
	return sal;
}
public void setSal(int sal) {
	this.sal = sal;
}
private int age;
   private int sal;
   
   Employe(String name,int ag,int salary)
   {
	   
	   ename=name;
	   age=ag;
	   sal=salary;
   }
   Employe(String s1,int salary)
   {
	   ename=s1;
	   sal=salary;
   }
   public static void main(String []args) throws SQLException, ClassNotFoundException
   {
	   Employe emp=new Employe("praveen",19,2500);
	   HashMap<Integer,Employe> h1=new HashMap <Integer,Employe>();
	   h1.put(1,emp);
	   Employe emp1=new Employe("smart",19,3500);
	   h1.put(2,emp1);
	   Employe emp2=new Employe("ashfaaq",19,25500);
	   h1.put(3,emp2);
	   emp2=new Employe("chan",19,45550);
	   h1.put(4,emp2);
	   emp2=new Employe("chadwick",20,54667);
	   h1.put(5,emp2);
	   
//	   for (Map.Entry<Integer, Employe> entry : h1.entrySet()) {
//		    System.out.println(entry.getKey()+" : "+entry.getValue());
//		}
	  // System.out.println(h1);
	  
	   //update name with respect to id

	   HashMap<Integer,Employe> h2= new HashMap<Integer,Employe>();
	   Employe s1= new Employe("thiru",19,3500);
	   h2.put(19, s1);
	   Employe s2= new Employe("abdulmajeed",21,3500);
	   h2.put(20,s2);	  
	  
	   //third hash for deletion
	   HashMap<Integer,Employe> h3= new HashMap<Integer,Employe>();
	   h3.put(19, s1);
	   h3.put(20,s2);
	   
	  
	   Connection con=null;
		Statement st=null;
		ResultSet rs=null;

	try 
	{
		//	Class.forName("com.mysql.jdbc.driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?useSSL=false","root","root");
			
			st=con.createStatement();
			String sql1=" insert into employe(ename,age,salary) values  (?,?,?) ";
			PreparedStatement ps;
			
			//insertion
			
			
			ps=con.prepareStatement(sql1);
			 for (Map.Entry<Integer, Employe> entry : h1.entrySet()) 
			 {
			    Employe result=entry.getValue();
			     int id= entry.getKey();
			     String name=result.getEname();
			     int age=result.getAge();
			     int sal=result.getSal();
				 //   System.out.println(entry.getKey()+" : "+entry.getValue());
			 
			  try
			  {
			  ps.setString(1,name);
			  ps.setInt(2, age);
			
			  ps.setInt(3, sal);
			  ps.addBatch();
			  }catch(Exception e)
			  {
				  System.out.println(e);
				  
			  }
			 }
			  int count[]=ps.executeBatch();
		
			
			   
			  //update
			  PreparedStatement stmt2 = (PreparedStatement) con.prepareStatement("update employe set ename=? where age=?");
			  
			  for (Map.Entry<Integer, Employe> entry : h2.entrySet()) 
			  {
				  Employe result1=entry.getValue();
				     int id1= entry.getKey();
				     String name = result1.getEname();
				     stmt2.setString(1, name);
				     stmt2.setInt(2, id1);
				     stmt2.addBatch();
			  }
			
			 int count1[]=stmt2.executeBatch();
			 
  
			 //deletion
			 
			 PreparedStatement stmt3 = (PreparedStatement) con.prepareStatement("delete from employe where ename=? and age=?");
			 for (Map.Entry<Integer, Employe> entry : h3.entrySet()) 
			  {
				  Employe result1=entry.getValue();
				     int id1= entry.getKey();
				     String name = result1.getEname();
				     stmt3.setString(1, name);
				     stmt3.setInt(2, id1);
				     stmt3.addBatch();
			  }
			 
			 int count2[]=stmt3.executeBatch();
			 System.out.println(count2.length);
		}
	catch (SQLException e) {
        e.printStackTrace();
    }
	if(st!=null)
		st.close();
		if(con!=null)
   			con.close();
//   }
}
}
