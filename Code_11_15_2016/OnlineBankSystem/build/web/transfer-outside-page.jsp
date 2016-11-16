<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer</title>
    </head>
    <body>
        <h1>Transfer Outside</h1>
        
        <form name="transfer" action="TransferOutsideServlet" method="post">
            From Account: <select name="accountFrom">
                <option></option>
            </select>
            
            <br/>
            To Account: <br/>
            Account Number: <input type="text" name="accountNum"> <br/>
            Last Name: <input type="text" name="lastName"> <br/>
            Amount: <input type="text" name="amount"> <br/>
            
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
