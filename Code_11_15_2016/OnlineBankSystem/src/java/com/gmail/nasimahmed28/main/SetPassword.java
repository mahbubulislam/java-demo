package com.gmail.nasimahmed28.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmail.nasimahmed28.database.RegistrationService;
import com.gmail.nasimahmed28.model.Registration;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

@WebServlet("/SetPassword")
public class SetPassword extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("set-password.jsp");
                dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String password = request.getParameter("password");
		String verifyPassword = request.getParameter("verifyPassword");
                
                HttpSession session;
                session = request.getSession();
                String token = (String) session.getAttribute("token");
		
		if(password.equals(verifyPassword))
		{
                     Registration regi = RegistrationService.setPassword(token, password);
			if(regi!= null)
			{
                                session.setAttribute("email", regi.getEmail());
				response.sendRedirect("DashboardPage");
			}
			else
			{
				response.sendRedirect("register-failure.jsp");
			}
		}
		else
		{
			response.sendRedirect("set-password.jsp");
		}
	}

}
