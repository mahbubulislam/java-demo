/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.mmi.cse;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gmail.mmi.cse.DBConnection;
import com.gmail.mmi.cse.UserInfo;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;

/**
 *
 * @author Mahbbul
 */
//@WebServlet(name = "AddUserInfo", urlPatterns = {"/adduserInfo"})
public class AddUserInfo extends HttpServlet {

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
            out.println("<title>Servlet AddUserInfo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddUserInfo at " + request.getContextPath() + "</h1>");
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
        //throw new ServletException("This is exception");

        Cookie[] arrCookies = request.getCookies();

        Cookie userName = null;
if(arrCookies.length >0){
    for (Cookie ck : arrCookies) {
            if (ck.getName().equals("userName")) {

                userName = ck;
                request.setAttribute("cookieUserName", ck.getValue());
            }

        }
}
        
        
        if(userName == null || !userName.getValue().equals("admin")){
            RequestDispatcher rd = request.getRequestDispatcher("login");
            rd.forward(request, response);
        }

        
        

        List users = DBConnection.getUserList();
        ServletConfig cfg = this.getServletConfig();
        ServletContext scfg = this.getServletContext();

        scfg.setAttribute("color", "Red");

        String slogan = scfg.getInitParameter("defaultSlogan");

        scfg.setInitParameter("defaultSlogan2", "The default slogan has overriden");

        request.setAttribute("defaultSlogan", slogan);

        String defaultSalutation = cfg.getInitParameter("defaultSalutation");
        request.setAttribute("defaultSaluation", defaultSalutation);
        request.setAttribute("Users", users);
        RequestDispatcher rd = request.getRequestDispatcher("myview.jsp");
        rd.forward(request, response);

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

        int r = 0;
        String operation = "";
        try {
            PrintWriter out = response.getWriter();

            operation = request.getParameter("submit");
            // operation = null
            if (null != operation) {
                UserInfo u = new UserInfo();
                u.setUserName(request.getParameter("username"));
                u.setUserAddress(request.getParameter("useraddress"));
                u.setUserPhone(request.getParameter("userphone"));
                r = DBConnection.saveUserInfo(u);

            }
            //redirect and get
            response.sendRedirect("adduserInfo");

        } catch (Exception e) {
            System.out.println(e);
        }

        // processRequest(request, response);
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
