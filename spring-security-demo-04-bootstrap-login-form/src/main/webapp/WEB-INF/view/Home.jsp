<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Luv2code Company Home Page</title>
</head>
<body>

	<h2>Luv2code Company Home Page - YooHoo!! - silly goose</h2>
	<hr>

	welcome to the Luv2code Company Home Page!
	
	<br><br>	

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		
		<input type="submit" value="LOGOUT">

	</form:form>

</body>
</html>