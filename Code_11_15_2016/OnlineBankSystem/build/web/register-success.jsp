<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>You have successfully Registered</h2>
	<p>Please click on the link to finish registration</p>
	<!-- <a href="RegistrationActivationServlet">Set Password</a> -->
	
	<form name="checkActivation" action="RegistrationActivationServlet" method="get">
		
		<input type="hidden" name="token" value= <%= session.getAttribute("token") %> >
		<input type="submit" name="submit" value="Submit" id="btnActivate">	
	 </form>  
	
</body>
</html>