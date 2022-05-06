package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn =null;
	/**
	*@see HttpServlet#HttpServlet()
	*/
	public RegisterServlet() {
		super();
		
	}
	/**see HttpServlet#doPost(HttpServletRequest request,HttpServletResponse response)
	 * 
	 */
 protected void dopost (HttpServletRequest request,HttpServletResponse response )throws ServletException, IOException{
	DbConnect cob = new DbConnect();
	String name = request.getParameter("sname");
	String pass = request.getParameter("spass");
	int age = Integer.parseInt(request.getParameter("sage"));
	String email = request.getParameter("semail");
	PrintWriter out=response.getWriter();
	conn =cob.getConnection();
	String sql ="insert into edustudent values(?,?,?,?)";
	try {
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1,name);
		pst.setString(2, email);
		pst.setString(2, pass);
		pst.setInt(4, age);
		int i= pst.executeUpdate();
		if(i>0) {
			out.println("Registertion success");
		}else {
			out.println("Error occurred");
		}
	}catch(SQLException e) {
		e.printStackTrace();
		}
	}
 }
	


