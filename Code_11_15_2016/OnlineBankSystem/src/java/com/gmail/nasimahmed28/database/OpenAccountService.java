/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.nasimahmed28.database;

import com.gmail.nasimahmed28.model.AccountType;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author NasimAhmed
 */
public class OpenAccountService
{

    public static int saveAccountType(AccountType account, String email)
    {
        int executeValue = 0;
        try
        {
            Connection conn = DBConnection.getConnection();
     
            String query = "INSERT INTO accountType (accountTypeID, accountType, minimumBalance, email)"
                    + "Values (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, account.getAccountTypeID());
            stmt.setString(2, account.getAccountType());
            stmt.setDouble(3, account.getMinBalance());
            stmt.setString(4, email);

            executeValue = stmt.executeUpdate();
        } catch (Exception e)
        {
            System.out.println(e);
        }
        return executeValue;
    }
}
