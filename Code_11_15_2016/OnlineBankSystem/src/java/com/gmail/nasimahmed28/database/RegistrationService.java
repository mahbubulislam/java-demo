package com.gmail.nasimahmed28.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.gmail.nasimahmed28.model.Registration;

public class RegistrationService
{

    public static int saveToRegistration(Registration register)
    {
        int executeValue = 0;
        try
        {
            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO Registration (firstName, lastName, email, token) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, register.getFirstName());
            stmt.setString(2, register.getLastName());
            stmt.setString(3, register.getEmail());
            stmt.setString(4, register.getToken());

            executeValue = stmt.executeUpdate();
        } catch (Exception e)
        {
            System.out.println(e);
        }
        return executeValue;
    }

    private static boolean checkToken(String token)
    {
        int c = 0;
        try
        {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT id FROM Registration WHERE token = '" + token + "' ";

            PreparedStatement stmt = conn.prepareStatement(query);
            //Statement stmt = conn.createStatement();
            //stmt.setString(1, token);

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next())
            {
                c = rs.getInt("id");
                break;
            }
        } catch (Exception e)
        {
            System.out.println(e);
        }

        System.out.println(c);
        if (c > 0)
        {
            return true;
        } else
        {
            return false;
        }
    }

    public static int validateUser(String token)
    {
        int updatedQueryValue = 0;
        System.out.println(token);

        if (RegistrationService.checkToken(token))
        {
            try
            {
                Connection conn = DBConnection.getConnection();
                String updateQuery = "UPDATE Registration set status = 1 where token =?";
                PreparedStatement stmt = conn.prepareStatement(updateQuery);
                stmt.setString(1, token);

                System.out.println(stmt.toString());

                updatedQueryValue = stmt.executeUpdate();
            } catch (Exception e)
            {
                System.out.println(e);
            }
        }
        System.out.println(updatedQueryValue);
        return updatedQueryValue;
    }

    public static Registration getRegistrationByToken(String token)
    {
        String email = "", firstName = "", lastName = "";
        Registration registration = new Registration();

        try
        {
            Connection conn = DBConnection.getConnection();
            String selectQuery = "SELECT * FROM Registration WHERE token=?";

            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            stmt.setString(1, token);
            ResultSet rs = stmt.executeQuery(selectQuery);

            rs.next();

            email = rs.getString("email");
            firstName = rs.getString("firstName");
            lastName = rs.getString("lastName");
            token = rs.getString("token");

            registration.setEmail(email);
            registration.setFirstName(firstName);
            registration.setLastName(lastName);
            registration.setToken(token);

        } catch (Exception e)
        {
             System.out.println(e);
        }
        return registration;
    }
    
     public static Registration getRegistrationByEmail(String token)
    {
        String email = "", firstName = "", lastName = "";
        Registration registration = new Registration();

        try
        {
            Connection conn = DBConnection.getConnection();
           // String selectQuery = "SELECT * FROM Registration WHERE email= '"+token+"'";
            
            String query = "SELECT firstName, lastName, email, token FROM Registration WHERE email =?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, token);
          //  PreparedStatement stmt = conn.prepareStatement(selectQuery);
           // stmt.setString(1, token);
           //Statement stmt = conn.createStatement();
          
            ResultSet rs = stmt.executeQuery();

            rs.next();

            email = rs.getString("email");
            firstName = rs.getString("firstName");
            lastName = rs.getString("lastName");
            token = rs.getString("token");

            registration.setEmail(email);
            registration.setFirstName(firstName);
            registration.setLastName(lastName);
            registration.setToken(token);

        } catch (Exception e)
        {
             System.out.println(e);
        }
        return registration;
    }
    
    

    public static Registration setPassword(String token, String password)
    {
        int executeValue = 0;
        Registration registration = null;
        try
        {
           
            registration = RegistrationService.getRegistrationByToken(token);
            
            System.out.println(registration.toString());
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt;

            String insertQuery = "INSERT INTO userProfile (email, firstName, lastName, Password) "
                    + "VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(insertQuery);
            stmt.setString(1, registration.getEmail());
            stmt.setString(2, registration.getFirstName());
            stmt.setString(3, registration.getLastName());
            stmt.setString(4, password);

            executeValue = stmt.executeUpdate();
            
        } catch (Exception e)
        {
            System.out.println(e);
        }

        return registration;
    }

    public static boolean validateLogin(String username, String password)
    {
        boolean valid = false;

        try
        {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM userProfile";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            String dbUsername = "", dbPassword = "";
            while (rs.next())
            {
                dbUsername = rs.getString("email");
                dbPassword = rs.getString("Password");
            }

            if (username.equals(dbUsername) && password.equals(dbPassword))
            {
                valid = true;
            } else
            {
                valid = false;
            }
        } catch (Exception e)
        {
            System.out.println(e);
        }
        return valid;
    }
}
