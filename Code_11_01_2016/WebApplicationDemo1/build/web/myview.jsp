
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<%@page import = "com.gmail.mmi.cse.UserInfo"%>
<%@page import = "java.util.ArrayList"%>
<%@page import = "java.util.Iterator"%>
<%@page import = "java.util.Date"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<%@ taglib prefix="ex" uri="WEB-INF/tlds/greet.tld" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $('.error-msg').hide();

                var isChecked = false;
                $('form[name="userinfo"]').submit(
                        function (e) {

                            return validateInput();


                        }
                );

                function validateFormfield(formEle) {
                    var isFieldValid;
                    if (formEle.val().length > 0) {
                        isFieldValid = true;
                        formEle.next().hide();
                    }
                    else {
                        //txtuserName.css('border','1px solid red');
                        // txtuserName.after('<p style="color:red">Please Enter Name</p>');
                        isFieldValid = false;
                        formEle.next().show();
                    }

                    return isFieldValid;
                }

                function validateInput() {
                    var allTextbox = $('input[type="text"]');
                    console.log(allTextbox);
                    var validate = true;
                    allTextbox.each(function (idx, val) {
                        // console.log(idx);
                        // console.log(val);
                        var ele = $(val);
                        //console.log(ele);
                        validate = validateFormfield(ele);
                    }

                    );

                    /* var txtuserName = $('#username');
                     var txtuserAddress = $('#useraddress');
                     var txtuserphone = $('#userphone');
                     var validate = true;
                     
                     validate = validateFormfield(txtuserName);
                     validate = validateFormfield(txtuserAddress);
                     validate = validateFormfield(txtuserphone);*/



                    //console.log(txtuserAddress);
                    // if(! isChecked){
                    /*  if (txtuserName.val().length > 0) {
                     validate = true;
                     txtuserName.next().hide();
                     }
                     else {
                     //txtuserName.css('border','1px solid red');
                     // txtuserName.after('<p style="color:red">Please Enter Name</p>');
                     validate = false;
                     txtuserName.next().show();
                     }
                     if (txtuserAddress.val().length > 0) {
                     validate = true;
                     txtuserAddress.next().hide();
                     }
                     else {
                     // txtuserAddress.css('border','1px solid red');
                     // txtuserAddress.after('<p style="color:red">Please Enter Address</p>');
                     validate = false;
                     txtuserAddress.next().show();
                     }
                     
                     if (txtuserphone.val().length > 0) {
                     validate = true;
                     txtuserphone.next().hide();
                     }
                     else {
                     //txtuserphone.css('border','1px solid red');
                     //txtuserphone.after('<p style="color:red">Please Enter Phone</p>');
                     validate = false;
                     txtuserphone.next().show();
                     
                     }
                     isChecked = true;*/
                    // }

                    return validate;
                }


            });

        </script>

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

        <ex:greet userName = "${cookieUserName}" />

        <ex:helloTag>
            ${cookieUserName}

        </ex:helloTag>

        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <a href="logout">Logout</a>
                    <h1>${cookieUserName}</h1>

                    <% out.print(application.getInitParameter("defaultSlogan2")); %>

                    <% out.print(application.getAttribute("color"));%>

                    <h1>${defaultSlogan2}</h1>
                    <h1>Create New User</h1>
                    <%@ include file="userInfo.jsp" %>
                </div>

            </div>
            <div class="row"> 
                <div class="col-md-12">
                    <table class="table table-striped">
                        <tr>
                            <td>Name</td>
                            <td>Address</td>
                            <td>Phone</td>
                            <td>Action</td>
                        </tr>
                        <c:forEach var="User" items="${Users}"> 
                            <tr>
                                <td><c:out value="${User.userName}"/>  </td>
                                <td><c:out value="${User.userAddress}"/></td> 
                                <td> <c:out value="${User.userPhone}"/> </td>
                                <td> <a href="EditUserInfo?id=${User.id}"> Edit </a> | <a href="DeleteUserInfo?id=${User.id}" onclick ="return confirm('Do you really want to delete?')"> Delete </a> </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

        </div>
 


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>      
    </body>
</html>