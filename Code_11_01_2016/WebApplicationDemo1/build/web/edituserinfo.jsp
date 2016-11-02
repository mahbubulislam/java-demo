
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<%@page import = "com.gmail.mmi.cse.UserInfo"%>
<%@page import = "java.util.ArrayList"%>
<%@page import = "java.util.Iterator"%>
<%@page import = "java.util.Date"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->


        <!-- Bootstrap -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h1>Edit User</h1>
                    <form name="userinfo" method="post" action="EditUserInfo">
                        <div class="form-group">
                            <label for="username">User Name</label>
                            <input type="text" name="username" class="form-control" id="username" value="${User.userName}" disabled="true"> 
                        </div>

                        <div class="form-group">
                            <label for="useraddress">User Address</label>
                            <input type ="text" name="useraddress" class="form-control" id="useraddress" value="${User.userAddress}"> 
                        </div>
                        <div class="form-group">
                            <label for="userphone">User Address</label>
                            <input type="text" name="userphone" class="form-control" id="userphone" value="${User.userPhone}"> 
                        </div>
                        <input type="hidden" name="key" value="${User.userName}"> 
                        <input name ="submit" type="submit" value="Update" class="btn btn-default">
                    </form>
                </div>

            </div>


        </div>


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>      
    </body>
</html>