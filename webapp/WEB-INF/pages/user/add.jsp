<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
</head>
<body>
<%@include file="../partials/header.html" %>
	<form action="add" method="post">
		<span>First Name</span><input type="text" name="firstName" required /><br>
		<span>Last Name</span><input type="text" name="lastName" required /><br>
		<span>Contact Number</span><input type="text" name="contactNo"
			required /><br> <span>Email Id</span><input type="text"
			name="email" required /><br> <input type="submit" value="submit">
	</form>
</body>
</html>