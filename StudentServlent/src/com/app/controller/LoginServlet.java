package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.StudentDao;
import com.app.model.Student;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int PRN=Integer.parseInt(request.getParameter("txtPRN"));
		Student s = null;
		//s.setPrn(PRN);
	//	int i=0;
		
		pw.write("<center><h1>Student University Result</h1></center>");
		try
		{
	        s=StudentDao.validation(PRN);		
		
		double total=(s.getS1()+s.getS2()+s.getS3());
		double Percentage=Math.round(((total/300)*100));
		
		if(Percentage>75.0)
		{
			pw.write("<center><h2>Passed with distinction</h2></center>");
		}
		else if(Percentage>60.0)
		{
			pw.write("<center><h2>first Division Passed</h2></center>");
		}
		else if(Percentage>50)
		{
			pw.write("<center><h2> Second Division Passed</h2></center>");
		}
		else if(Percentage>35)
		{
			pw.write("<center><h2>Passed<h2></center>");
		}
		else
		{
			pw.write("<center><h2>fail<h2></center>");
		}
		
		
		pw.write("<center><table border=1 width=50% heigth=50%><tr>"
				+ "<th>PRN</th>"
				+ "<th>name</th>"
				+ "<th>Subject1</th>"
				+ "<th>Subject2</th>"
				+ "<th>Subject3</th>"
				+ "<th>Total Marks</th>"
				+ "<th>Percentage</th>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>"+s.getPrn()+"</td>"
				+"<td>"+s.getName()+"</td>"
				+"<td>"+s.getS1()+"</td>"
				+"<td>"+s.getS2()+"</td>"
				+"<td>"+s.getS3()+"</td>"
				+"<td>"+total+"</td>"
				+"<td>"+Percentage+"</td>"
				+ "</table></center>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
