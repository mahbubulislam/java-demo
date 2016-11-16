<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.gmail.nasimahmed28.database.RegistrationService"%>
<%@page import="com.gmail.nasimahmed28.model.Registration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User-Profile</title>
</head>
<body>
	<form name="userProfile" action="UserProfileServlet" method="post">
                <% 
                    
                    String token = (String) session.getAttribute("token");
                     Registration registration;
                    if(token != null)
                    {
                        registration = RegistrationService.getRegistrationByToken(token);
                        
                    }
                    else
                    {
                        String email = (String) session.getAttribute("email");
                        registration = RegistrationService.getRegistrationByEmail(email);
                    }
                    
                  %>
		First Name: <input type="text" name="firstname" value="<%=registration.getFirstName()%>" required> <br/>
		Last Name: <input type="text" name="lastname" value="<%= registration.getLastName()%>" required> <br/>
		Address: <input type="text" name="address"> <br/>
		Date of Birth: <input type="text" name="dob"> <br/>
		Contact Number: <input type="text" name="contactNum"> <br/>
		Gender: 
			<input type="radio" name="gender" value="Male"> Male
			<input type="radio" name="gender" value="Female"> Female <br/>
			
		Marital Status:
			<input type="radio" name="maritalStatus" value="Single"> Single
			<input type="radio" name="maritalStatus" value="Married"> Married <br/>
			
		Job Address: <input type="text" name="jobAddress"> <br/> <br/>
		<input type="submit" name="submit" value="Submit">
	</form>
	
</body>
</html>