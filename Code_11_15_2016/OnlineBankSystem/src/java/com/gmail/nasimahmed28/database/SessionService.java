/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.nasimahmed28.database;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NasimAhmed
 */
public class SessionService
{
    public static boolean validateSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        if(null == session){
          return false; 
        }
        else{
           String email = (String) session.getAttribute("email");
           if(null ==email){
               return false;
           }
           else{
               return true;
           }
        }
      
    }   
}
