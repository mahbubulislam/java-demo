package com.gmail.nasimahmed28.database;

import com.gmail.nasimahmed28.model.AccountType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gmail.nasimahmed28.model.UserProfile;

public class UserProfileService 
{	
	public static void saveUserProfile(UserProfile profile)
	{
		//int executedValue = 0;
		try
		{
			Connection conn = DBConnection.getConnection();

			String query = "INSERT INTO Registration (firstName, lastName, address, dob, contactNumber, Gender, maritalStatus, jobAddress) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, profile.getFirstName());
			stmt.setString(2, profile.getLastName());
			stmt.setString(3, profile.getAddress());
			stmt.setString(4, profile.getDOB());
			stmt.setString(5, profile.getContactNum());
			stmt.setString(6, profile.getGender());
			stmt.setString(7, profile.getMaritalStatus());
			stmt.setString(8, profile.getJobddress());
			
                        stmt.executeUpdate();
                        
			//executedValue = stmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		//return executedValue;
	}
        
        public static String getAccountTypeByEmail(String email)
        {
          //  AccountType accountType = new AccountType();
            String getAccountType = "";
            try
            {
                Connection conn = DBConnection.getConnection();
                String query = "SELECT * FROM accountType WHERE email=?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, email);
                
                ResultSet rs = stmt.executeQuery(query);
                rs.next();
                
                getAccountType = rs.getString("accountType");
                
              //  accountType.setAccountType(getAccountType);
                          
            } catch (Exception e)
            {
                System.out.println(e);
            }
            
          //  return accountType;
          return getAccountType;
        }
        
        public static int getAmountOfAccounts(String email)
        {
            int count = 0;
            try
            {
                Connection conn = DBConnection.getConnection();
                String query = "SELECT count(*) FROM accountType WHERE email=?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, email); 
                
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next())
                {
                   String account = rs.getString("accountType");
                   count++;
                }
                          
            } catch (Exception e)
            {
                System.out.println(e);
            }
            
            return count;
        }
}
