<%@page import="com.gmail.nasimahmed28.database.UserProfileService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer</title>
    </head>
    <body>
        <h1>Transfer</h1>
        
        <form name="transfer" action="TransferServlet" method="post">
            <% 
                String email = (String) session.getAttribute("email");
                String getAccountType = UserProfileService.getAccountTypeByEmail(email);
                int count = UserProfileService.getAmountOfAccounts(email);
             %>
            From Account: <select name="accountFrom">                  
            <%
               for(int i = 0; i < count; i++)
               {
            %>
                <option>  <%=getAccountType %>
            <%
                }
            %> 
               </option>
            </select> <br/>    
            
            To Account: <select name="accountTo">
                                 <option></option>
                        </select>
            <br/>   
            
            Amount: <input type="text" name="amount"> <br/>

            <input type="submit" value="Submit">
        </form>                         
    </body>
</html>
