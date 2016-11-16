package com.gmail.nasimahmed28.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gmail.nasimahmed28.database.RegistrationService;
import com.gmail.nasimahmed28.model.Registration;

@WebServlet("/registerservlet")
public class RegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Registration register = new Registration();
		register.setFirstName(request.getParameter("firstname"));
		register.setLastName(request.getParameter("lastname"));
		register.setEmail(request.getParameter("email"));
		register.setToken(10);
		HttpSession session;

		if (RegistrationService.saveToRegistration(register) > 0)
		{
			String token = register.getToken();
			System.out.println("Token is: " + token);
			//request.setAttribute("token", token);
			session = request.getSession();
			session.setAttribute("token", token);
			response.sendRedirect("register-success.jsp"); // send to servlet
		}
		else
		{
			response.sendRedirect("register-failure.jsp");
		}
	}

}
