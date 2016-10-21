
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<%@page import = "com.gmail.mmi.cse.UserInfo"%>
<%@page import = "java.util.ArrayList"%>
<%@page import = "java.util.Iterator"%>
<%@page import = "java.util.Date"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create New User</h1>
        <%@ include file="userInfo.jsp" %>
        <table>
            <tr>
            <td>Name</td>
            <td>Address</td>
            <td>Phone</td>
            </tr>
            
        
       <tr>
           <td> <c:forEach var="User" items="${Users}"> </td>
               <td>      <c:out value="${User.userName}"/>  </td>
               <td><c:out value="${User.userAddress}"/></td> 
               <td> <c:out value="${User.userPhone}"/> </td>
                 <tr>
            </c:forEach>
                  </table>
            
    </body>
</html>
