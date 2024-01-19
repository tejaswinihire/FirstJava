package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.model.Student;

public class StudentDao {
	public static Connection getConnection()throws SQLException
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			System.out.println("Connection establish");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public static Student validation(int PRN) throws SQLException
	{
		Student s2 = new Student();
		Connection con=StudentDao.getConnection();
		PreparedStatement stmt=con.prepareStatement("select * from student where Prn=?");
		stmt.setInt(1,PRN);
		ResultSet rs=stmt.executeQuery();
		//boolean s1 = rs.next();
	
		while(rs.next())
		{
            s2.setPrn(rs.getInt("Prn"));
            s2.setName(rs.getString("name"));
            s2.setS1(rs.getInt("S1"));
            s2.setS2(rs.getInt("S2"));
            s2.setS3(rs.getInt("S3"));
		}
		
		return s2 ;
	}

}
