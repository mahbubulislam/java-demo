package com.gmail.nasimahmed28.main;

import com.gmail.nasimahmed28.database.SessionService;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmail.nasimahmed28.database.UserProfileService;
import com.gmail.nasimahmed28.model.UserProfile;

@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       // SessionService.validateSession(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
      //  response.sendRedirect("set-profile.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserProfile profile = new UserProfile();

        profile.setFirstName(request.getParameter("firstname"));
        profile.setLastName(request.getParameter("lastname"));
        profile.setAddress(request.getParameter("address"));
        profile.setDOB(request.getParameter("dob"));
        profile.setGender(request.getParameter("gender"));
        profile.setContactNum(request.getParameter("contactNum"));
        profile.setMaritalStatus(request.getParameter("maritalStatus"));
        profile.setJobddress(request.getParameter("jobAddress"));

       // UserProfileService.saveUserProfile(profile);
        
        /*
        if (UserProfileService.saveUserProfile(profile) > 0)
        {
            response.sendRedirect("dashboard-page.jsp");
        } else
        {
            response.sendRedirect("UserProfileServlet");
        }
*/
    }

}
