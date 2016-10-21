/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.mmi.cse;

/**
 *
 * @author Mahbbul
 */
import java.sql.*;
import java.util.ArrayList;
import com.gmail.mmi.cse.UserInfo;
import java.util.List;

public class DBConnection {
    
    private static String DBName= "db_demo";
    private static String DBURL= "jdbc:mysql://localhost:3306/db_demo";
    private static String DBUserName = "root" ;
    private static String DBUserPass = "root";
    private static Connection con;
    private static PreparedStatement stmt;
    
    private static void connectToDB() {
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            DBConnection.con = DriverManager.getConnection(DBConnection.DBURL,DBConnection.DBUserName,DBConnection.DBUserPass); 
            
        }catch(Exception e) { 
            System.out.println(e);
         } 
    }
    
    public static int saveUserInfo(UserInfo userInfo) throws Exception{
        try{
            DBConnection.connectToDB();
            String q = "INSERT INTO userinfo(username,useraddress,userphone) values(?,?,?)";
            stmt = DBConnection.con.prepareStatement(q);
            stmt.setString(1,userInfo.getUserName());
            stmt.setString(2,userInfo.getUserAddress());
            stmt.setString(3,userInfo.getUserPhone());
        }catch(Exception e) { 
            System.out.println(e);
        } 
       return stmt.executeUpdate();
        
    }
    
    public static ArrayList getUserList() throws Exception{
        
        ArrayList <UserInfo> users = new ArrayList<UserInfo>(); 
        try{
            DBConnection.connectToDB();
            String q = "SELECT * from userinfo";
            stmt = DBConnection.con.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
             
            
            while(rs.next())  {
            
                UserInfo b1 = new UserInfo();
                b1.setUserName(rs.getString("username"));
                b1.setUserAddress(rs.getString("useraddress"));
                b1.setUserPhone(rs.getString("userphone"));
                users.add(b1);
            }
            
        }catch(Exception e) { 
            System.out.println(e);
        } 
       return users ;
        
    }
    
    
}
