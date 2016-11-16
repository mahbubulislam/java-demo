package com.gmail.nasimahmed28.main;

import com.gmail.nasimahmed28.database.AccountService;
import com.gmail.nasimahmed28.database.OpenAccountService;
import com.gmail.nasimahmed28.database.SessionService;
import com.gmail.nasimahmed28.model.Account;
import com.gmail.nasimahmed28.model.AccountType;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OpenAccountServlet")
public class OpenAccountServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // SessionService.validateSession(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // processRequest(request, response);
        //response.sendRedirect("openaccount-page.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        if (email != null)
        {
            AccountType accountType = new AccountType();
            String getAccountType = request.getParameter("accountType");
            String minBalance = request.getParameter("minDeposit");

            if (getAccountType.equals("Checking Account"))
            {
                accountType.setAccountType("Checking");
                accountType.setMinBalance(250.0);
                accountType.setAccountTypeID(10);
            } else if (getAccountType.equals("Saving Account"))
            {
                accountType.setAccountType("Saving");
                accountType.setMinBalance(100);
                accountType.setAccountTypeID(10);
            } else if (getAccountType.equals("Credit Card"))
            {
                accountType.setAccountType("Credit Card");
                accountType.setMinBalance(500);
                accountType.setAccountTypeID(10);
            }

            if (OpenAccountService.saveAccountType(accountType, email) > 0)
            {
                Account account = new Account();
                account.setAccountID(10);
                AccountService.setAccount(email, account);
                
                response.sendRedirect("dashboard-page.jsp");
            }
        } 
        else
        {
            response.sendRedirect("Login");
        }
    }
}
