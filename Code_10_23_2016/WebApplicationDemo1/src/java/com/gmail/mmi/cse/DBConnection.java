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

    private static String DBName = "db_demo";
    private static String DBURL = "jdbc:mysql://localhost:3306/db_demo";
    private static String DBUserName = "root";
    private static String DBUserPass = "root";
    private static Connection con;
    private static PreparedStatement stmt;

    private static void connectToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DBConnection.con = DriverManager.getConnection(DBConnection.DBURL, DBConnection.DBUserName, DBConnection.DBUserPass);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int saveUserInfo(UserInfo userInfo) {
        int res =0;
        try {
            DBConnection.connectToDB();
            String q = "INSERT INTO userinfo(username,useraddress,userphone) values(?,?,?)";
            stmt = DBConnection.con.prepareStatement(q);
            stmt.setString(1, userInfo.getUserName());
            stmt.setString(2, userInfo.getUserAddress());
            stmt.setString(3, userInfo.getUserPhone());
            res= stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;

    }

    public static UserInfo getUserInfoById(int id) {
        UserInfo u = new UserInfo();
        try {
            DBConnection.connectToDB();
            String q = "SELECT * FROM userinfo WHERE sl=?";
            stmt = DBConnection.con.prepareStatement(q);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            u.setUserName(rs.getString("username"));
            u.setUserAddress(rs.getString("useraddress"));
            u.setUserPhone(rs.getString("userphone"));

        } catch (Exception e) {
            System.out.println(e);
        }
        return u;

    }
    
    public static int updateUserInfoById(UserInfo u) {
        int res=0;
        try {
            DBConnection.connectToDB();
            String q = "UPDATE  userinfo set useraddress=?, userphone=?  WHERE username=?";
            stmt = DBConnection.con.prepareStatement(q);
            stmt.setString(1, u.getUserAddress());
            stmt.setString(2, u.getUserPhone());
            stmt.setString(3, u.getUserName());
            
             res= stmt.executeUpdate();
           

        } catch (Exception e) {
            System.out.println(e);
        }
        return res;

    }
    
    public static int deleteUserInfoById(int id) {
        int res=0;
        try {
            DBConnection.connectToDB();
            String q = "DELETE FROM  userinfo WHERE sl=?";
            stmt = DBConnection.con.prepareStatement(q);
            stmt.setInt(1, id);
            res= stmt.executeUpdate();
           

        } catch (Exception e) {
            System.out.println(e);
        }
        return res;

    }

    public static List getUserList() {

        List users = new ArrayList<UserInfo>();
        try {
            DBConnection.connectToDB();
            String q = "SELECT * from userinfo";
            stmt = DBConnection.con.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                UserInfo b1 = new UserInfo();
                b1.setUserName(rs.getString("username"));
                b1.setUserAddress(rs.getString("useraddress"));
                b1.setUserPhone(rs.getString("userphone"));
                b1.setId(rs.getInt("sl"));
                users.add(b1);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return users;

    }

}
