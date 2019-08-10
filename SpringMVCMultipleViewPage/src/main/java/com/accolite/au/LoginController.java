package com.accolite.au;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController 
{
 
	
	  static HashMap<String ,Integer> h1 = new HashMap<String ,Integer>();
	  Connection con=null;
	  Statement st=null;
	  
	@RequestMapping("/login")
	public String   greet  (HttpServletRequest req,Model m) 
	{
		String userEmail= req.getParameter("email");
		String userPassword = req.getParameter("pass");
		
		try
		{
			
			Class.forName("com.mysql.jdbc.driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpagedb?useSSL=false","root","root");
//			//con=DriverManager.getConnection(" jdbc:mysql://localhost:3306/loginpagedb?useSSL=false ","root","root");
			st=con.createStatement();
		
			PreparedStatement ps;
//			System.out.println("working");
			String sql1= "select  password from users where email=userEmail ";
//			
			ps=con.prepareStatement(sql1);
			ResultSet rs= ps.executeQuery(sql1);
			String password;
			
//			//while(rs.next())
			{
			   password=rs.getString(1);    	
//			   System.out.println(password);
		}
			if(userPassword == password)
			{
				return "hello";
			}
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
//		System.out.println(userPassword);
		
		int errorCount = 0;
		long cur= System.currentTimeMillis();
		long wait=cur-getWaittime();
		
		wait=(wait/1000)/60;
		
       return "loginsuccesful";
	}
	
	@RequestMapping("/loginform")
	public String login() 
	{
		return "loginsuccesful";
	}
	
	@RequestMapping("/Admin")
	public String admin() 
	{
		return "Admin";
	}
	
	
	 
}
