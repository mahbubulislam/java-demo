<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Close Account</title>
    </head>
    <body>
        <h1>Close Account</h1>
        
        <form name="closeAccount" action="CloseAccountServlet" method="post">
            Account Type: <select name="accountType">
                <option></option>
            </select> <br/>
            
            Current Balance: <input type="text" name="balance" value=""> <br/>
            Account To Transfer To: <select name="transfer">
                <option></option>
            </select> <br/>
            
            Reason to Close: <br/>
            <textarea rows="4" cols="50"></textarea> <br/>
            
            <input type="submit" value="Submit">
            
        </form>
    </body>
</html>
