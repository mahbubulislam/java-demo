package com.gmail.nasimahmed28.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmail.nasimahmed28.database.RegistrationService;

@WebServlet("/RegistrationActivationServlet")
public class RegistrationActivationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String token = request.getParameter("token"); 
		
		System.out.println(token);

		System.out.println(RegistrationService.validateUser(token));

		if(RegistrationService.validateUser(token) > 0)
		{
			response.sendRedirect("SetPassword"); 
		}
		else
		{
			response.sendRedirect("register-page.jsp"); //change
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}
