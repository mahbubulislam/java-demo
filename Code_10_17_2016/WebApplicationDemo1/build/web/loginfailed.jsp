<%-- 
    Document   : loginfailed
    Created on : Oct 16, 2016, 11:41:40 AM
    Author     : Mahbbul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please try with valid credentials.</h1>
        <%
            HttpSession sess = request.getSession();
            String userName =  (String) sess.getAttribute("userName");
            
           out.println("<p>Session Value is " + userName + "</p>");
        %>
        
            
    </body>
</html>
