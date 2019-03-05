<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Login</title>
</head>
<body>
<%@include file="../partials/header.html" %>
	<form action="../update" method="post">
		<span>ID</span><input type="text" name="id" required value="${user.id}"  readonly="readonly"/><br>
		<span>First Name</span><input type="text" name="firstName" value="${user.firstName}" required /><br>
		<span>Last Name</span><input type="text" name="lastName" value="${user.lastName}" required /><br>
		<span>Contact Number</span><input type="text" name="contactNo" value="${user.contactNo}"
			required /><br> 
			<span>Email Id</span><input type="text"
			name="email" required value="${user.email}" /><br> <input type="submit" value="submit">
	</form>
</body>
</html>