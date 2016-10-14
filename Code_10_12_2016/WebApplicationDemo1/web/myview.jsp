<%-- 
    Document   : myview
    Created on : Oct 13, 2016, 6:39:43 PM
    Author     : Mahbbul
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "com.gmail.mmi.cse.UserInfo"%>
<%@page import = "java.util.ArrayList"%>
<%@page import = "java.util.Iterator"%>
<%@page import = "java.util.Date"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        ArrayList users =  (ArrayList) request.getAttribute("Users");
        Date d =new Date();
         
        Iterator itr = users.iterator();
      
      while(itr.hasNext()) {
         UserInfo element = (UserInfo) itr.next(); %>
         
         <p> <%= element.getUserName()%> </p>
         <p> <%= element.getUserAddress()%> </p>
         <p> <%= element.getUserPhone()%> </p>
         
         
     <% 
      }
   %>
   
     <p> Response Generated on: <%= d %> </p>   
      
<!--        <h1>
            ${Users[0].userName}</h1>
        <p>${Users[0].userAddress}</p>
        <p>${Users[0].userPhone}</p>
        <h1>Hello World!</h1>-->
    </body>
</html>
