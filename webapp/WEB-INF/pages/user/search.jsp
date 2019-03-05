<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>
<body>
	<%@include file="../partials/header.html"%>
	</br>
	<form action="search_result" method=get>
		<select name="attribute">
			<option value=first_name>First Name</option>
			<option value=last_name>Last Name</option>
			<option value=contact_no>Contact No</option>
			<option value=email>Email ID</option>
		</select> <input id="value" type="text" name="attribute_value" required /> <br>
		<input type="submit" value="submit">
	</form>
</body>
</html>