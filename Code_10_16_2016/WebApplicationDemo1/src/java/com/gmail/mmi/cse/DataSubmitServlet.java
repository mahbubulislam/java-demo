/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.mmi.cse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahbbul
 */
@WebServlet(name = "DataSubmitServlet", urlPatterns = {"/submitdata"})
public class DataSubmitServlet extends HttpServlet {

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
            out.println("<title>Data has submitted !!</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DataSubmitServlet at " + request.getContextPath() + "</h1>");
            
            //String paramName = request.getParameter("txtName");
            
            Enumeration allParams = request.getParameterNames();
            while(allParams.hasMoreElements()){
                String paramName = (String) allParams.nextElement();
                out.println("<h1>Param : " + paramName + "</h1>");
                
                String[] paramValues = request.getParameterValues(paramName);
                if(paramValues.length == 1){
                    out.println("<p>The value we have got : " + paramValues[0] + "</p>");
                }else{
                    out.println("<ul>");
                    for(int i=0;i<paramValues.length;i++){
                        out.println( "<li>" + paramValues[i] + "</li>");
                    }
                    out.println("</ul>");
                }
            }
            
            /*String[] paramName = request.getParameterValues("txtName");
            String[] paramVehicals = request.getParameterValues("vehicle");
            
            out.println("<h1>The value we have got : " + paramName[0] + "</h1>");
            
            out.println("<ul>");
            for(int i=0;i<paramVehicals.length;i++){
                out.println( "<li>" + paramVehicals[i] + "</li>");
            }
            out.println("</ul>");*/
            
            
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
        processRequest(request, response);
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
        processRequest(request, response);
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
