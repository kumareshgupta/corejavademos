package com.urs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urs.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("userId");
		int userId = Integer.parseInt(uid);
		//create Service object
		UserService userService = new UserService();
		
		//get user details
		String name = userService.getUserDetails(userId);
		request.setAttribute("userName", name);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
		dispatcher.forward(request, response);
		
		/*
		PrintWriter out = response.getWriter();
		out.println("<HTML><BODY><h2>");
		out.println(name);
		out.println("</h2></BODY></HTML>"); */
		
		
		//PrintWriter out = response.getWriter();
		//out.println("<H2>"+uid +"</H2>");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
