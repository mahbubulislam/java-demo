<%-- 
    Document   : error-page.jsp
    Created on : Oct 26, 2016, 7:55:07 PM
    Author     : Mahbbul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!
            <% exception.printStackTrace(response.getWriter()); %>
     
        </h1>
    </body>
</html>
