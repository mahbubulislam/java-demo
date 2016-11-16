package com.gmail.nasimahmed28.database;

import com.gmail.nasimahmed28.model.Account;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccountService
{
    public static String getEmailSessions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        
        System.out.println(email);
        
        return email;
    }
    
    public static void setAccount(String email, Account account)
    {
        try
        {
            Connection conn = DBConnection.getConnection();
            
            String getAccountTypeID = "SELECT * FROM accountType WHERE email= '"+email+"'";
            PreparedStatement stmt = conn.prepareStatement(getAccountTypeID);
          //  stmt.setString(1, email);
            
            ResultSet rs = stmt.executeQuery(getAccountTypeID);
            int accountTypeID = 0;
            
            while(rs.next())
            {
                accountTypeID = rs.getInt("accountTypeID");
            }
            
            String insertQuery = "INSERT INTO account (accountID, emailID, accountTypeID)"
                    + "VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(insertQuery);
            stmt.setInt(1, account.getAccountID());
            stmt.setString(2, email);
            stmt.setInt(3, accountTypeID);
            
            stmt.executeQuery(); // error here
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
