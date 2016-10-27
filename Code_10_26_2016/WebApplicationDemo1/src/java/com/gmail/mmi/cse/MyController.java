/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.mmi.cse;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Mahbbul
 */
@WebServlet(name = "MyController", urlPatterns = {"/MyController"})
public class MyController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            String DBName = "db_demo";
            String DBURL = "jdbc:mysql://localhost:3306/" + DBName;
            String DBUserName = "root";
            String DBUserPass = "root";
            
            Connection con = DriverManager.getConnection( DBURL,DBUserName,DBUserPass);  
           
            //here sonoo is database name, root is username and password  
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from userinfo");  
            ArrayList<UserInfo> users = new ArrayList<UserInfo>();  
            
            while(rs.next())  {
            
                UserInfo b1 = new UserInfo();
                b1.setUserName(rs.getString("username"));
                b1.setUserAddress(rs.getString("useraddress"));
                b1.setUserPhone(rs.getString("userphone"));
                users.add(b1);
            }
            
          // request.setAttribute("Users", users);
            request.getSession().setAttribute("Users", users);
        
         RequestDispatcher rd = request.getRequestDispatcher("myview.jsp");  
         rd.forward(request, response);  
         con.close();  
        }catch(Exception e){ System.out.println(e);}  
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
