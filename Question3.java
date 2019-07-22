package javadb;

import java.sql.*;
public class Question3 
{

	public static void main(String [] args)
	{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?useSSL=false","root","root");
			
			st=con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE);
			String sql="select * from student";
			rs=st.executeQuery(sql);
			//first insert
			rs.moveToInsertRow();
			rs.updateInt(1, 3);
			rs.updateString(2,"ashfaaq");
			rs.updateString(3,"CT");
			rs.updateString(4,"male");
			
			rs.insertRow();
		//second insert 
			rs.moveToInsertRow();
			rs.updateInt(1, 46);
			rs.updateString(2,"rahul");
			rs.updateString(3,"CT");
			rs.updateString(4,"male");
			rs.insertRow();
			
			
			//update command 
			while(rs.next())
			{
			   String name =rs.getString("name");
			   name="ashfaaqbhai";
			   rs.updateString("name", name);
			   rs.updateRow();
			}
			
		}catch(SQLException e)
		{
			System.out.println(e);
		}
	}
 
}
