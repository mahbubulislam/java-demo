<%-- 
    Document   : newjsp
    Created on : Oct 13, 2016, 2:26:32 PM
    Author     : Mahbbul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%
    String title = "Accessing Request Param";
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1><% out.print(title); %></h1>
        <p>
               
               ${MyBean.val}
        </p>
        
        <p>${header["user-agent"]}</p>
        
        <jsp:useBean id="date" class="java.util.Date" /> 
        <p>The date/time is ${date} ss</p>
        
        <hr/>
       
    </body>
</html>
