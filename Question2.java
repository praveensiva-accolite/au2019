package javadb;

import java.sql.*;

public class MetaDataOperations {

	public static void main(String[] args) throws SQLException{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			
		//	Class.forName("com.mysql.jdbc.Driver");
			]
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldcup?useSSL=false", "root", "root");
			
			stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE,
				    ResultSet.HOLD_CURSORS_OVER_COMMIT);
			
			rs = stmt.executeQuery("select * from team");
			System.out.println("World Cup Summary:");
			System.out.println("Team_Id"+"  "+"Team_Name"+"  "+"Total_Wins");
			while (rs.next())
				System.out.println(rs.getInt("team_id") + "        " + rs.getString("country") + "      " + rs.getInt("tournament_win"));
			System.out.println("Structural info/metadat of table TEAM:");
			DatabaseMetaData dmd=con.getMetaData();
			System.out.println("1)Keywords in SQL: "+dmd.getSQLKeywords());
			System.out.println("2)Driver Version: "+dmd.getDriverVersion());
            System.out.println("3)Driver Name: "+dmd.getDriverName());
            System.out.println("4)Database Product Name: "+dmd.getDatabaseProductName());
            System.out.println("5)Database Product Version: "+dmd.getDatabaseProductVersion());
            System.out.println("6)Metadata URL: "+dmd.getURL());
            System.out.println("7)Metadata Username: "+dmd.getUserName());
            rs=dmd.getTables(null, null, "%", null);
            System.out.println("8)Tables in WORLDCUP database:");
            while (rs.next()) {
            	   System.out.println((rs.getString(3).toLowerCase()));
            	  }
            
		}
		catch (Exception e) 
		{
			System.out.println(e);
		} 
		finally 
		{
		// close the connection
			if (con != null)
				con.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}
	}
}