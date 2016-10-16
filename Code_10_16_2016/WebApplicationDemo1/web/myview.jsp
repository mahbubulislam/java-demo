
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <% 
        ArrayList users =  (ArrayList) request.getAttribute("Users");
        Date d =new Date();
         
        Iterator <UserInfo> itr = users.iterator();
      
      while(itr.hasNext()) {
         UserInfo element = itr.next();
        out.println("ss<hr/>");
        %>
         
         <p> <%= element.getUserName()%> </p>
         <p> <%= element.getUserAddress()%> </p>
         <p> <%= element.getUserPhone()%> </p>
         
         
     <% 
      }
   %>
   
     <p> Response Generated on: <%= d %> </p>   
     
     <c:out value="${'Welcome to javaTpoint'}"/>  
      
<!--        <h1>
            ${Users[0].userName}</h1>
        <p>${Users[0].userAddress}</p>
        <p>${Users[0].userPhone}</p>
        <h1>Hello World!</h1>-->
            
            <c:forEach var="User" items="${Users}">
                  <c:out value="${User.userName}"/> 
                  <c:out value="${User.userAddress}"/>
                  <c:out value="${User.userPhone}"/>
            </c:forEach>
            
            <c:set var="salary" scope="session" value="${2000*2}"/>
            <c:out value="${salary}"/>
            
            
            <c:if test="${salary > 2000}">
                <p>My salary is: <c:out value="${salary}"/><p>
            </c:if>
    </body>
</html>
