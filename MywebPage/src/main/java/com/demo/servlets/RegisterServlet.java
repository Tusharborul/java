//package com.demo.servlets;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import com.demo.beans.MyUser;
//import com.demo.beans.Person;
//import com.demo.services.LoginService;
//import com.demo.services.LoginServicesImpl;
//
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public class RegisterServlet extends HttpServlet {
//	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		res.setContentType("text/html");
//		
//		PrintWriter out= res.getWriter();
//		String fname=req.getParameter("fname");
//		String laname=req.getParameter("laname");
//		String gender=req.getParameter("Gender");
//		String Uname=req.getParameter("Uname");
//		String Pass=req.getParameter("Pass");
//		String degree=req.getParameter("degree");
//		String city =req.getParameter("city");
//		String[] skills=req.getParameterValues("Skills");
//		LoginService ls= new LoginServicesImpl();
//		Person p1 =new Person(fname,laname,gender,degree,skills,city );
//		MyUser u1=new MyUser(Uname,Pass,"User");
//		boolean status=ls.registeruser(p1,u1);
//			if(status) {
//				out.print("<h1>Added Succssfully</h1>");
//			}else {
//				out.print("<h1>Added unSuccssfully</h1>");
//			}
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//	}

package com.demo.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.MyUser;
import com.demo.beans.Person;

import com.demo.services.LoginService;
import com.demo.services.LoginServicesImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//retrieve data from registration form
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String uname=request.getParameter("uname");
		String password=request.getParameter("passwd");
		String gender=request.getParameter("gender");
		String degree=request.getParameter("degree");
		String city=request.getParameter("city");
		String[] skills=request.getParameterValues("skills");
		LoginService ls=new LoginServicesImpl();
		//pass data to add in person table and user table
		Person p1=new Person(fname,lname,gender,degree,skills,city);
		System.out.println("in servlet "+uname+"-------"+password);
		MyUser u1=new MyUser(uname,password,"user");
		boolean status=ls.registeruser(p1,u1);
		if(status) {
			//if registration is successful
			out.println("<h3>Registeration successfully done, Pls login</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
			
		}else {
			//registration is unsuccessful
			out.println("<h3>Registeration not done, Pls re-register</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		
	}
	

}


	

