<%-- 
    Document   : login
    Created on : Oct 16, 2016, 11:35:31 AM
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
        <h1>Hello World!</h1>
        <form name="login" action="MyRestrictedServlet" method="post">
            <input type="text" name="txtUserName">
            <input type ="password" name="txtPassword">
            <input type="submit" name="btnSubmit" value="Submit">
        </form>
    </body>
</html>
