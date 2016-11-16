/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.nasimahmed28.main;

import com.gmail.nasimahmed28.database.SessionService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author NasimAhmed
 */
@WebServlet(name = "DashboardPage", urlPatterns = { "/DashboardPage" })

public class DashboardPage extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        SessionService.validateSession(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
      // processRequest(request, response);
     if(  SessionService.validateSession(request, response)){
          RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard-page.jsp");
          dispatcher.forward(request, response);	
     }
     else{
         RequestDispatcher dispatcher = request.getRequestDispatcher("login-page.jsp");
         dispatcher.forward(request, response);
     }
      
      
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }
}
