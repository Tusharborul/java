package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.MyUser;
import com.demo.services.LoginService;
import com.demo.services.LoginServicesImpl;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
    	res.setContentType("text/Html");
    	PrintWriter out=res.getWriter();
    	String uname=req.getParameter("uname");
    	String pass=req.getParameter("pass");
    	LoginService ls=new LoginServicesImpl();
    	MyUser user=ls.validateUser(uname,pass);
    	if(user!=null && user.getRole().equals("user")) {
    		out.println("<h1>Login successful</h1>");
    	}else {
    		out.println("<h1>Login unsuccessful</h>");
    	}
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		doGet(request,response);
	}
}
